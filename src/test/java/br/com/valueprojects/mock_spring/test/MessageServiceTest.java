package br.com.valueprojects.mock_spring.test;

import br.com.valueprojects.mock_spring.infra.MessageSMS;
import br.com.valueprojects.mock_spring.infra.MessageWPP;
import br.com.valueprojects.mock_spring.model.TipoMensagem;
import br.com.valueprojects.mock_spring.services.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MessageServiceTest {

    private MessageSMS messageSMS;
    private MessageWPP messageWPP;
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        messageSMS = mock(MessageSMS.class);
        messageWPP = mock(MessageWPP.class);
        messageService = new MessageService(messageSMS, messageWPP);
    }

    @Test
    void deveEnviarSmsQuandoTipoForSMS() {
        messageService.sendMessage(TipoMensagem.SMS, "Teste SMS");
        verify(messageSMS, times(1)).sendSms("Teste SMS");
        verifyNoInteractions(messageWPP);
    }

    @Test
    void deveEnviarWppQuandoTipoForWHATSAPP() {
        messageService.sendMessage(TipoMensagem.WHATSAPP, "Teste WPP");
        verify(messageWPP, times(1)).sendWpp("Teste WPP");
        verifyNoInteractions(messageSMS);
    }
}