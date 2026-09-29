package com.google.cloud.solutions.realtimedash.dashboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class JedisBeanConfiguration {

  @Value("${spring.redis.host}")
  private String REDIS_HOST;

  @Value("${spring.redis.port}")
  private Integer REDIS_PORT;

  @Bean
  Jedis redisClient() {
    return new Jedis(REDIS_HOST, REDIS_PORT);
  }
}
