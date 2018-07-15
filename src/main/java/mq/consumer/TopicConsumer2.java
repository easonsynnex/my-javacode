package mq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.testng.annotations.Test;

import javax.jms.*;

/**
 * Created by easony on 07/06/18.
 */
public class TopicConsumer2 {
    private final static String queueName = "my-activemq-topic";

    @Test
    public void TopicConsumer2() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(queueName);

            MessageConsumer consumer = session.createConsumer(destination);
            TextMessage message = (TextMessage)consumer.receive();
            System.out.println("Receive message ---->  " + message.getText());

            session.commit();
            session.close();

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
