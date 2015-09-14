package com.github.oscerd;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;

public class ProducerTest
{
    @Test
    public void testSimpleProducer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> prod = new KafkaProducer<String, String>(props);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test", "Kafka rocks");
        prod.send(record);

        prod.close();
    }
}
