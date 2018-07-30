package mq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.testng.annotations.Test;

import javax.jms.*;

public class PersistenceTopicConsumer {
    private final static String queueName = "my-activemq-topic";
    private final static String clientId = "eason-0001";

    @Test
    public void persistenceTopicConsumer() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();

            connection.setClientID(clientId);
            connection.start();

            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            Topic destination = session.createTopic(queueName);
            //持久化订阅,接收离线消息
            MessageConsumer consumer = session.createDurableSubscriber(destination, clientId);
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
