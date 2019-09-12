package com.example.minio_event;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EventRecv1 {

    public static final String BUCKET_QUEUE = "bucketqueues";

    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("passw0rd");
        final Connection connection = connectionFactory.newConnection();
        final Channel channel =
                connection.createChannel();

        channel.queueDeclare(BUCKET_QUEUE, true, false, false, null);

        channel.exchangeDeclare(
                "bucketevents", BuiltinExchangeType.FANOUT, true, false, null);
//        final String QUEUE_NAME = channel.queueDeclare().getQueue(); // 每次启动一个临时的，如果是多个节点部署的话，存在重复消费的情况。
        // 而且队列不存在没法接受消息，所以消息得提前创建，并且消息保持持久话

        System.out.println("queue: " + BUCKET_QUEUE);


        channel.queueBind(BUCKET_QUEUE, "bucketevents", "bucketlogs");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            final String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'"); // 如果失败了
        };
        channel.basicConsume(BUCKET_QUEUE, true, deliverCallback, consumerTag -> {});

    }
}
