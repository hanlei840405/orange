package com.fruit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by hanlei6 on 2016/12/22.
 */
@Component
public class MqConfig {

    @Bean
    public Queue studentInsertQueue() {
        return new Queue("queue.student.insert", true, false, true);
    }

    @Bean
    public Queue studentUpdateQueue() {
        return new Queue("queue.student.update", true, false, true);
    }

    @Bean
    public Queue studentDeleteQueue() {
        return new Queue("queue.student.delete", true, false, true);
    }

    @Bean
    public Queue categoryInsertQueue() {
        return new Queue("queue.category.insert", true, false, true);
    }

    @Bean
    public Queue categoryUpdateQueue() {
        return new Queue("queue.category.update", true, false, true);
    }

    @Bean
    public Queue categoryDeleteQueue() {
        return new Queue("queue.category.delete", true, false, true);
    }
}
