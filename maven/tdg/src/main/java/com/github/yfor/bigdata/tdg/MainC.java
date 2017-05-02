package com.github.yfor.bigdata.tdg;

public class MainC {

    public static void main(String[] args) {

        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.start();

    }
}
