package com.github.oscerd;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class SimplePartitionsProducer {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        props.put("partitioner.class", "com.github.oscerd.SimplePartitioner");

        Random rnd = new Random(new Long(200));
        KafkaProducer<String, String> prod = new KafkaProducer<String, String>(props);

        for (int i = 0; i < 100; i++) {
            String key = String.valueOf(rnd.nextInt(Integer.MAX_VALUE));
            String msg = String.valueOf(System.currentTimeMillis());
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("test", key, msg);
            Future<RecordMetadata> l = prod.send(record);
            try {
                RecordMetadata meta = l.get();
                System.out.println("Metadata: Write message [ " + msg + " ] with key [ " + key + " ] on partition [ " + meta.partition() + " ]");
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        prod.close();
    }
}
