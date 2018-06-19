import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  public messageReceived: Subject<string>;

  constructor() {
    this.messageReceived = new Subject<string>();
  }
  public async sendMessage(message: string) {
  }

  private onMessageReceived(message: string) {
    this.messageReceived.next(message);
  }
}
