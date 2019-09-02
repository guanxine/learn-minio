package com.example.minio_event;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EventRecv {

    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("passw0rd");
        final Connection connection = connectionFactory.newConnection();
        final Channel channel =
                connection.createChannel();

        channel.exchangeDeclare(
                "bucketevents", BuiltinExchangeType.FANOUT, false, false, null);
        final String QUEUE_NAME =
                channel.queueDeclare().getQueue();

        System.out.println("queue: " + QUEUE_NAME);


        channel.queueBind(QUEUE_NAME, "bucketevents", "bucketlogs");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            final String message = new String(delivery.getBody(), "UTF-8");


            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});

    }
}
