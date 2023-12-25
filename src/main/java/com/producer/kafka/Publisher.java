package com.producer.kafka;

import com.producer.Constraint;
import com.producer.model.User;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void userCreated(User user){
//        kafkaTemplate.send(Constraint.USER_CREATED,User)
//                .headers(new RecordHeaders().add(new RecordHeader("__TypeId__", "com.producer.model.User".getBytes())));
        kafkaTemplate.send(Constraint.USER_CREATED, user);
    }
}
