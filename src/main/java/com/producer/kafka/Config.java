package com.producer.kafka;


import com.producer.Constraint;
import com.producer.model.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@Configuration
public class Config {

    @Bean
    public KafkaTemplate<String, User> kafkaTemplate(ProducerFactory<String, User> producerFactory) {
        KafkaTemplate<String, User> template = new KafkaTemplate<>(producerFactory);
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }

    @Bean
    public NewTopic topic(){

        return TopicBuilder.name(Constraint.USER_CREATED)
               // .replicas(1)
                //.partitions()
                .build();
    }
}
