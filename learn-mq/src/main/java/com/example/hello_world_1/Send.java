package com.example.hello_world_1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {


    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("passw0rd");
        try(Connection connection = connectionFactory.newConnection();
            final Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "hello, world";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

            System.out.println(" [x] Send '" + message + "'");
            Thread.sleep(1000 * 60);

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
