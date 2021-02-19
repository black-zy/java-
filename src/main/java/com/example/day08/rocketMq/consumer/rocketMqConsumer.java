package com.example.day08.rocketMq.consumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.Date;
import java.util.List;

public class rocketMqConsumer {

    public static void main(String[] args) throws MQClientException {
        //同步消费
        ayscConsumer();
        //延迟消费
        //delayConsumer();
    }
    /**
     * 同步消费
     * @throws MQClientException
     */
    public static void ayscConsumer() throws MQClientException {
        // 400条消息  totalTime:15110
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("rmq-group");
        defaultMQPushConsumer.setNamesrvAddr("47.98.119.224:9876;47.98.119.224:9877");
        defaultMQPushConsumer.setInstanceName("consumer");
        defaultMQPushConsumer.subscribe("test-topic-linster","tag1");
        //单个消费者中多线程并行消费
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            Long totalTime = 0L;
            Date date1 = null;
            Date date2 = new Date();
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg: list){
                        System.out.println("queueId:"+msg.getQueueId()+",orderId:"+new String(msg.getBody())+",i:"+msg.getKeys());

                }
                long end = System.currentTimeMillis();
                //System.out.println("耗时："+(end-start));
//                if(date1 == null)
//                    date1 = new Date();
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("totalTime:"+totalTime);
//                date2 = new Date();
//                totalTime = (date2.getTime() - date1.getTime());
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        defaultMQPushConsumer.start();
        System.out.println("消费开始");
    }

    public static void delayConsumer() throws MQClientException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("rmq-group1");
        defaultMQPushConsumer.setNamesrvAddr("47.98.119.224:9876;47.98.119.224:9877");
        defaultMQPushConsumer.setInstanceName("consumer");
        defaultMQPushConsumer.subscribe("TestTopic2","tag2");
        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                MessageExt messageExt = list.get(0);
                int reconsumeTimes = messageExt.getReconsumeTimes();
                System.out.println(System.currentTimeMillis()+"//"+messageExt.getMsgId()+"-----"+messageExt.getBody());
                if(reconsumeTimes > 3){
                    consumeConcurrentlyContext.setDelayLevelWhenNextConsume(-1);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }else {
                    consumeConcurrentlyContext.setDelayLevelWhenNextConsume(3);
                }
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        defaultMQPushConsumer.start();
        defaultMQPushConsumer.fetchSubscribeMessageQueues("TestTopic2");
        System.out.println("消费开始");
    }

}
