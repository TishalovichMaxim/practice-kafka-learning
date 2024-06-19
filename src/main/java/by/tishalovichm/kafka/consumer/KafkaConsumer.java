package by.tishalovichm.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${kafka.topics.string-topic.name}",
            groupId = "${kafka.consumers.group-id}")
    public void consume(String message) {
        LOGGER.info(String.format("Consumed message: %s", message));
    }

}
