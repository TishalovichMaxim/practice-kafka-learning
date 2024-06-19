package by.tishalovichm.kafka.consumer;

import by.tishalovichm.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${kafka.topics.json-topic.name}",
            groupId = "${kafka.consumers.group-id}")
    public void consume(User user) {
        LOGGER.info(String.format("Consumed user: %s", user.toString()));
    }

}
