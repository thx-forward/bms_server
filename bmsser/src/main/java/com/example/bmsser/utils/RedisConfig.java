package com.example.bmsser.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;

@Configuration
public class RedisConfig {

    @Autowired
    RedisTemplate redisTemplate = null;

    @Autowired
    RedisConnectionFactory connectionFactory=null;

    @Autowired
    ThreadPoolTaskScheduler taskScheduler = null;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    private void initRedisTemplate(){
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
    }

    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler(){
        if(taskScheduler!=null){
            return taskScheduler;
        }
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(initTaskScheduler());
        return container;
    }



}
