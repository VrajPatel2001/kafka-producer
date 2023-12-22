package com.producer.kafka;

import com.producer.Constraint;
import com.producer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void UserCreated(User User){
        kafkaTemplate.send(Constraint.USER_CREATED,User);
    }
}
