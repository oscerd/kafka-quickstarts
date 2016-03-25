package com.github.oscerd;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerMultipleTopic {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        
        KafkaProducer<String, String> prod = new KafkaProducer<String, String>(props);

        ProducerRecord<String, String> data1 = new ProducerRecord<String, String>("test2", "test2");
        ProducerRecord<String, String> data2 = new ProducerRecord<String, String>("test3", "test3");

        prod.send(data1);
        prod.send(data2);

        prod.close();
    }
}
