A set of Apache Kafka Quickstarts

## Simple Producer

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

- Start consumer

```
bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning
```

- Run mvn clean compile exec:exec

- You should see the message in the consumer terminal.
