package com.github.yfor.bigdata.tdg;

public class MainP {

    public static void main(String[] args) {
        Producer producerThread = new Producer(KafkaProperties.topic);
        producerThread.start();


    }
}
