import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import * as Amqp from "amqp-ts";


@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  public messageReceived: Subject<string>;

  constructor() {
    this.messageReceived = new Subject<string>();
  }
  public async sendMessage(message: string) {
    var connection = new Amqp.Connection("amqp://localhost");
    var exchange = connection.declareExchange("ExchangeName");
    var queue = connection.declareQueue("QueueName");
    queue.bind(exchange);
    queue.activateConsumer((message) => {
      console.log("Message received: " + message.getContent());
    });

    var msg = new Amqp.Message("Test");
    exchange.send(msg);
    console.log("Sent: Test")

    connection.completeConfiguration().then(() => {
      var msg2 = new Amqp.Message("Test2");
      console.log("Sent: Test2")
      exchange.send(msg2);
    });

  }

  private onMessageReceived(message: string) {
    this.messageReceived.next(message);
  }
}
