package com.wipro.bookingservice.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic bookingTopic() {
        return TopicBuilder.name("booking-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
