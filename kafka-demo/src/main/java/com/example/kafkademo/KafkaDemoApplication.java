package com.example.kafkademo;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Autowired
    private KafkaTemplate template;

    @GetMapping("/send/{input}")
    @Transactional(rollbackFor = RuntimeException.class)
    public void sendFoo(@PathVariable String input) throws Exception {
        ProducerRecord<String, String> record = new ProducerRecord<>("topic-kl", input);
        template.send(record);
    }

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    @GetMapping("/stop/{listenerID}")
    public void stop(@PathVariable String listenerID) {
        registry.getListenerContainer(listenerID).pause();
    }

    @GetMapping("/resume/{listenerID}")
    public void resume(@PathVariable String listenerID) {
        registry.getListenerContainer(listenerID).resume();
    }

    @GetMapping("/start/{listenerID}")
    public void start(@PathVariable String listenerID) {
        registry.getListenerContainer(listenerID).start();
    }

    @KafkaListener(id = "webGroup", topics = "topic-kl", autoStartup = "false")
    public String listen(String input) {
        System.out.println("input value: " + input);
        return "successful";
    }
}
