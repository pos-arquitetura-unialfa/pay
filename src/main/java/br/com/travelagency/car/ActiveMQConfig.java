package br.com.travelagency.car;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class ActiveMQConfig {

    public static final String SEND_PAY = "PagamentoReservaCarro";
    
}
