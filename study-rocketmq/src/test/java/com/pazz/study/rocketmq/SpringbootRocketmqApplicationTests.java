package com.pazz.study.rocketmq;

public class SpringbootRocketmqApplicationTests {

//    public static void main(String[] args) {
//        try {
//            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
//            producer.setNamesrvAddr("120.79.141.169:9876");
//            producer.setVipChannelEnabled(false);
//            producer.start();
//            for (int i = 10; i < 20; i++) {
//                try {
//                    Message msg = new Message("TopicTest", "TagA", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
//                    System.out.println(msg);
//                    SendResult sendResult = producer.send(msg);
//                    System.out.printf("%s%n", sendResult);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Thread.sleep(200);
//                }
//            }
//            producer.shutdown();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) throws Exception {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");
//        consumer.setNamesrvAddr("120.79.141.169:9876");
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//        consumer.subscribe("TopicTest", "*");
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//                System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });
//        consumer.start();
//        System.out.printf("Consumer Started.%n");
//    }

}
