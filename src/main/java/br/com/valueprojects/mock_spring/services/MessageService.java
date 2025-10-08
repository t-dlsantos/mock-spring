package br.com.valueprojects.mock_spring.services;

import br.com.valueprojects.mock_spring.model.TipoMensagem;
import infra.JogoDao;
import infra.MessageSMS;
import infra.MessageWPP;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageSMS messageSMS;
    private MessageWPP messageWPP;

    public MessageService(MessageSMS messageSMS, MessageWPP messageWPP) {
        this.messageSMS = messageSMS;
        this.messageWPP = messageWPP;
    }

    public void sendMessage(TipoMensagem tipo, String mensagem) {
        switch(tipo) {
            case SMS -> messageSMS.sendSms(mensagem);
            case WHATSAPP ->  messageWPP.sendWpp(mensagem);
        }
    }
}