package infra;

import org.springframework.stereotype.Component;

@Component
public class MessageWPP {

    public void sendWpp(String mensagem) {
        System.out.println("WHATSAPP: " + mensagem);
    }

}
