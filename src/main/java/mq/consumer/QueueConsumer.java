package mq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.testng.annotations.Test;

import javax.jms.*;

/**
 * Created by easony on 07/06/18.
 */
public class QueueConsumer {
    private final static String queueName = "activemq-queue";

    @Test
    public void queueProvider() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            /*
            CLIENT_ACKNOWLEDGE 客户端确认
            AUTO_ACKNOWLEDGE  自动确认，客户端接收消息无需做额外工作
            DUPS_OK_ACKNOWLEDGE消息延迟确认。 指定消息提供者在消息接收者没有确认发
送时重新发送消息， 这种模式不在乎接受者收到重复的消
息。
             */
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
