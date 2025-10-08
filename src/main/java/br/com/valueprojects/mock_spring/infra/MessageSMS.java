package br.com.valueprojects.mock_spring.infra;

import org.springframework.stereotype.Component;

@Component
public class MessageSMS {

    public void sendSms(String mensagem) {
        System.out.println("SMS: " + mensagem);
    }

}
