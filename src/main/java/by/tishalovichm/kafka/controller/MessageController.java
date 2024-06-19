package by.tishalovichm.kafka.controller;

import by.tishalovichm.kafka.model.User;
import by.tishalovichm.kafka.producer.JsonKafkaProducer;
import by.tishalovichm.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message published");
    }

    @PostMapping("users")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("User published");
    }

}
