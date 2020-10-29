package com.example.kafkademo;

import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@EmbeddedKafka(count = 4, ports = {9092, 9093, 9094, 9095})
@SpringBootTest
class KafkaDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    KafkaProperties kafkaProperties;

    @Test
    public void testCreateTopic() {

        AdminClient client = AdminClient.create(kafkaProperties.buildAdminProperties());
        CreateTopicsResult topics = client.createTopics(Collections.singleton(new NewTopic("dynamic-created-topic", 1, (short) 1)));
    }


    @Autowired
    KafkaTemplate kafkaTemplate;

    @Test
    public void sendResult() {
        // 异步获取发送结果
        kafkaTemplate.send("", "").addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("failure");
            }

            @Override
            public void onSuccess(Object o) {
                System.out.println("success");
            }
        });
    }

    @Test
    public void sendResultSyn() throws ExecutionException, InterruptedException {
        // 同步获取发送结果
        ListenableFuture future = kafkaTemplate.send("", "");
        System.out.println(future.get());

    }

    @Test
    public void sendInTransaction() {
        // 需要配置事务ID前缀
        // spring.kafka.producer.transaction-id-prefix
        kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback() {
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                kafkaOperations.send("", "");
                if (new Random().nextBoolean()) {
                    throw new RuntimeException("");
                }
                kafkaOperations.send("", "");
                return null;
            }
        });
    }


}
