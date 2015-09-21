## Producer and multiple Topics

- Download a recent stable version of Apache Kafka (0.8.2.1)

- Untar the package

- Enter into Kafka directory

- Start Zookeeper Server

```
bin/zookeeper-server-start.sh config/zookeeper.properties
```

- In a different terminal start Kafka Server

```
bin/kafka-server-start.sh config/server.properties
```

- Create a topic test (if not exists)

```
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```

- Create a topic test1 (if not exists)

```
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test1
```

- Start consumer on topic test

```
bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning
```

- Start consumer on topic test1

```
bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test1 --from-beginning
```

- Run mvn clean compile exec:exec

- You should see the message in the consumer terminal.
