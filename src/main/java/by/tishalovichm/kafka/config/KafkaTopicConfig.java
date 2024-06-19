package by.tishalovichm.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic stringTopic(@Value("${kafka.topics.string-topic.name}") String name) {
        return TopicBuilder.name(name)
                .build();
    }

    @Bean
    public NewTopic jsonTopic(@Value("${kafka.topics.json-topic.name}") String name) {
        return TopicBuilder.name(name)
                .build();
    }

}
