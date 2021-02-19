package com.example.day08.rocketMq.product;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.util.List;

public class listenerOrderlyProduct {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        producer.setNamesrvAddr("47.98.119.224:9876;47.98.119.224:9877");
        producer.setInstanceName("producer");
        producer.start();
        try {
            new Thread(()->{
                Integer orderId= 1;
                try {
                    sendsMessage(producer,orderId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RemotingException e) {
                    e.printStackTrace();
                } catch (MQClientException e) {
                    e.printStackTrace();
                } catch (MQBrokerException e) {
                    e.printStackTrace();
                }
            }).start();

//            new Thread(()->{
//                Integer orderId= 4;
//                try {
//                    sendsMessage(producer,orderId);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (RemotingException e) {
//                    e.printStackTrace();
//                } catch (MQClientException e) {
//                    e.printStackTrace();
//                } catch (MQBrokerException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//
//            new Thread(()->{
//                Integer orderId= 3;
//                try {
//                    sendsMessage(producer,orderId);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (RemotingException e) {
//                    e.printStackTrace();
//                } catch (MQClientException e) {
//                    e.printStackTrace();
//                } catch (MQBrokerException e) {
//                    e.printStackTrace();
//                }
//            }).start();
            Thread.sleep(30000);
            producer.shutdown();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    private static void sendsMessage(DefaultMQProducer producer,Integer orderId) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        for (int i = 0; i < 400; i++) {
            try {
                Message msg = new Message("test-topic-linster","tag1",String.valueOf(i),String.valueOf(orderId).getBytes());
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        System.out.println(index);
                        System.out.println("队列得到长度："+mqs.toString());
                        return mqs.get(index);
                    }
                },orderId);
                System.out.println(sendResult.toString()+orderId);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
