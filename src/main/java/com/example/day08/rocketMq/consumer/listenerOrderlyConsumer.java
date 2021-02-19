package com.example.day08.rocketMq.consumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.Date;
import java.util.List;

/**
 * 顺序消费实战
 * rocketMQ  怎么保证消费顺序
 * 实际测试中  并发消费要比顺序消费效率要高很多，在不考虑严格顺序下尽量使用并发消费
 */
public class listenerOrderlyConsumer {
    //顺序消费优先
    public static void main(String[] args) throws MQClientException {
        // 400条消息  totalTime:40776
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name_3");
        consumer.setNamesrvAddr("47.98.119.224:9876;47.98.119.224:9877");

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe("test-topic-linster", "tag1");

        //消费者并行消费
        consumer.registerMessageListener(new MessageListenerOrderly() {
            Long totalTime = 0L;
            Date date1 = null;
            Date date2 = new Date();
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
//                context.setAutoCommit(false);
//                long start = System.currentTimeMillis();
//                for (MessageExt msg : msgs) {
//                    System.out.println("queueId:"+msg.getQueueId()+",orderId:"+new String(msg.getBody())+",i:"+msg.getKeys());
//                }
//                long end = System.currentTimeMillis();
//                long total = end-start;
//                System.out.println(total++);
                if(date1 == null)
                    date1 = new Date();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("totalTime:"+totalTime);
                date2 = new Date();
                totalTime = (date2.getTime() - date1.getTime());

                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.out.printf("Consumer Started.%n");

    }
}
