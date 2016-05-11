package hello.jms.ping;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Random;

import static hello.utils.ReceiversConstants.MAILBOX_DESTINATION;

@Component
public class PingReceiver {

    /**
     * When you receive a message, print it out, then shut down the application. Finally, clean up any ActiveMQ server
     * stuff.
     */
    @JmsListener(destination = MAILBOX_DESTINATION, containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {

        final int sleepTime = new Random().nextInt(1500);
        System.out.println(String.format("PingReceiver sleeping %d ms....", sleepTime));
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
        }
        System.out.println("back to work!");

        System.out.println("the receive read the ping message <" + message + ">");
    }
}