package com.example.day08.rocketMq.product;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.CountDownLatch;

public class rocketMqProduct {
    /**
     * 同步消息发送
     * @throws MQClientException
     */
    public static void SyncProducer() throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        producer.setNamesrvAddr("47.98.119.224:9876;47.98.119.224:9877");
        producer.setInstanceName("producer");
        producer.start();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                Message msg = new Message("test-topic","tag1",("message"+i).getBytes());
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult.toString());
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //SyncProducer  同步发送方法
        //SyncProducer();
        //AsyncProducer  异步发送方法
        //AsyncProducer();
        //delayProduct   延迟消息发送
        delayProduct();
    }

    /**
     * 异步发送消息
     */
    public static void AsyncProducer() throws MQClientException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("rmq-group");
        defaultMQProducer.setNamesrvAddr("47.98.119.224:9876;47.98.119.224:9877");
        defaultMQProducer.start();
        defaultMQProducer.setRetryTimesWhenSendFailed(0);
        int messCount = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(messCount);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                final int index = i;
                Message msg = new Message("test-topic2","Tag2","Order188",("hello,world"+i).getBytes());
                defaultMQProducer.send(msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d OK %s %n",index,sendResult.getMsgId());
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        countDownLatch.countDown();
                        System.out.printf("%-10d Exception %s %n", index, throwable);
                        throwable.printStackTrace();
                    }
                });
            }catch (Exception e ){
                e.printStackTrace();
            }
        }

    }

    /**
     * 延迟消息
     */
    public static void delayProduct() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // Instantiate a producer to send scheduled messages
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group1");
        producer.setNamesrvAddr("47.98.119.224:9876;47.98.119.224:9877");
        producer.setInstanceName("producer");
        // Launch producer
        producer.start();
        int totalMessagesToSend = 1;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("TestTopic2", "tag2",String.valueOf(i),("延迟消息发送 " + i).getBytes());
            // This message will be delivered to consumer 10 seconds later.
            //message.setDelayTimeLevel(3);
            // Send the message
            SendResult sendResult = producer.send(message);
            System.out.printf("%-10d OK %s %n",i,sendResult.getMsgId());
        }

        // Shutdown producer after use.
        producer.shutdown();
    }
}
