package gw2.messaging;


import gw2.main.MainApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message){
        try {
            System.out.println("Received <" + message + ">");
            latch.countDown();
            RabbitTemplate template = new RabbitTemplate();
            template.convertAndSend(MainApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
            latch.await(10000, TimeUnit.MILLISECONDS);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
