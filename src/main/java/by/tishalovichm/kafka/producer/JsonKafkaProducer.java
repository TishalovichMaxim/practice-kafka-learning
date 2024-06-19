package by.tishalovichm.kafka.producer;

import by.tishalovichm.kafka.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Value("${kafka.topics.json-topic.name}")
    private String topicName;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {

        LOGGER.info(String.format("Produced user: %s", user.toString()));

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        kafkaTemplate.send(message);
    }

}
