package mq.provider;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;
import org.testng.annotations.Test;

import javax.jms.*;

/**
 * Created by easony on 07/09/18.
 */
public class DeferredDeliveryProvider {
    private final static String queueName = "delay-queue1";

    @Test
    public void DeferredDeliveryProvider() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD,"failover:(tcp://localhost:61616)");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);

            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            TextMessage message = session.createTextMessage("Hello world:" + System.currentTimeMillis());

            long time = 20 * 1000;// 延时1min
            long period = 10 * 1000;// 每个10s
            int repeat = 6;// 6次
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, time);
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
            message.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);

            producer.send(message);
            session.commit();
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
