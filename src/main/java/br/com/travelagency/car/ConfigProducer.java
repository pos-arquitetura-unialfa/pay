
package br.com.travelagency.car;

import static br.com.travelagency.car.ActiveMQConfig.SEND_PAY;

import java.util.List;
import java.util.UUID;

import javax.jms.DeliveryMode;
import javax.jms.Message;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service
public class ConfigProducer {

    private static Logger log = LoggerFactory.getLogger(ConfigProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;
    
    public void sendQueue(String model) {
					jmsTemplate.convertAndSend(SEND_PAY, model, m -> {
					     log.info("setting standard JMS headers before sending");
				            m.setJMSCorrelationID(UUID.randomUUID().toString());
				            m.setJMSExpiration(1000);
				            m.setJMSMessageID("message-id");
				            m.setJMSDestination(new ActiveMQQueue(SEND_PAY));
				            m.setJMSReplyTo( new ActiveMQQueue(  "order-queueRepy"));
				            m.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
				            m.setJMSPriority(Message.DEFAULT_PRIORITY);
				            m.setJMSTimestamp(System.nanoTime());

				            log.info("setting custom JMS headers before sending");
				            m.setStringProperty("jms-custom-header", "this is a custom jms property");
				            m.setBooleanProperty("jms-custom-property", true);
				            m.setDoubleProperty("jms-custom-property-price", 0.0);
				            return m;
					});
    }
}

