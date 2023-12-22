package com.producer.kafka;


import com.producer.Constraint;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {

    @Bean
    public NewTopic topic(){

        return TopicBuilder.name(Constraint.USER_CREATED)
               // .replicas(1)
                //.partitions()
                .build();
    }
}
