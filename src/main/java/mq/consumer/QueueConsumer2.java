package mq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.testng.annotations.Test;

import javax.jms.*;

/**
 * Created by easony on 07/06/18.
 */
public class QueueConsumer2 {
    private final static String queueName = "my-activemq-queue";

    @Test
    public void queueConsumer2() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            /*
            CLIENT_ACKNOWLEDGE 客户端确认
            AUTO_ACKNOWLEDGE  自动确认，客户端接收消息无需做额外工作
            DUPS_OK_ACKNOWLEDGE消息延迟确认。 指定消息提供者在消息接收者没有确认发
                                送时重新发送消息， 这种模式不在乎接受者收到重复的消息。
             */
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);

            MessageConsumer consumer = session.createConsumer(destination);
            for (int i = 0;i < 10 ; i++) {
                TextMessage message = (TextMessage) consumer.receive();
                System.out.println("Receive message2 ---->  " + message.getText());
            }

 /*           MessageListener messageListener=new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(((TextMessage)message).getText());
                        message.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            };
            consumer.setMessageListener(messageListener);
            session.commit();
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            //CLIENT_ACKNOWLEDGE
            //message.acknowledge();
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
