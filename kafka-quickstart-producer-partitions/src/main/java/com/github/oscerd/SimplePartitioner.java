package com.github.oscerd;

import kafka.producer.Partitioner;

public class SimplePartitioner implements Partitioner{

    @Override
    public int partition(Object key, int numberOfPartitions) {
        int partition = 0;
        int intKey = Integer.parseInt((String) key);
        if (intKey > 0) {
            partition = intKey % numberOfPartitions;
        }
        return partition;
    }

}
