package mq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.testng.annotations.Test;

import javax.jms.*;

/**
 * Created by easony on 07/06/18.
 */
public class QueueConsumer {
    private final static String queueName = "my-activemq-queue";

    @Test
    public void queueConsumer() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);

            MessageConsumer consumer = session.createConsumer(destination);
            TextMessage message = (TextMessage)consumer.receive();
            System.out.println("Receive message ---->  " + message.getText());

            //CLIENT_ACKNOWLEDGE
            //message.acknowledge();

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
