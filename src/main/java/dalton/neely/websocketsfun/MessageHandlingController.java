package dalton.neely.websocketsfun;

import dalton.neely.websocketsfun.models.Message;
import dalton.neely.websocketsfun.models.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageHandlingController {
    @MessageMapping("/app/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        System.out.println("received message " + message.getText() + ". From user " + message.getFrom());
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
