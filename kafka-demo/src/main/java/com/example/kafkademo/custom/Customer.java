package com.example.kafkademo.custom;

import lombok.extern.log4j.Log4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;

/**
 * @author bo li
 * @date 2020-10-29 19:06
 */
public class Customer {

    @KafkaListener(id = "webGroup", topicPartitions = {
            @TopicPartition(topic = "topic1", partitions = {"0", "1"}),
            @TopicPartition(topic = "topic2", partitions = "0",
                    partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))
    }, concurrency = "6", errorHandler = "myErrorHandler") // errorHandler = "myErrorHandler" 自定义异常处理器
    public String listen(String input) {
        System.out.println("input value: " + input);
        return "successful";
    }
}
