package com.utils.serviceusagepublisher.producer;

import com.google.gson.Gson;
import com.utils.serviceusagepublisher.model.UsageTrackingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsageTrackerProducer {

    @Value("${usage.tracker.topic-id}")
    private String TOPIC;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(UsageTrackingMessage message) {
        Gson gson = new Gson();
        kafkaTemplate.send(TOPIC, gson.toJson(message));
    }
}
