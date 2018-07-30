package mq.provider;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.testng.annotations.Test;

import javax.jms.*;

/**
 * Created by easony on 07/06/18.
 */
public class TopicProvider {

    private final static String queueName = "my-activemq-topic";

    @Test
    public void topicProvider() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(queueName);

            MessageProducer producer = session.createProducer(destination);
            //消息持久化
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            TextMessage message = session.createTextMessage("Hello, this is topic");
            producer.send(message);

            /*session.commit();
            session.close();*/
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
