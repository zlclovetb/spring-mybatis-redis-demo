package com.paradm.mybatis.springcache;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching
@Configuration
public class SpringCacheConfig extends CachingConfigurerSupport {
  private volatile JedisConnectionFactory jedisConnectionFactory;
  private volatile RedisTemplate<String, String> redisTemplate;
  private volatile RedisCacheManager redisCacheManager;

  public SpringCacheConfig() {
    super();
  }

  public SpringCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate, RedisCacheManager redisCacheManager) {
    this.jedisConnectionFactory = jedisConnectionFactory;
    this.redisTemplate = redisTemplate;
    this.redisCacheManager = redisCacheManager;
  }

  public JedisConnectionFactory getJedisConnecionFactory() {
    return jedisConnectionFactory;
  }

  public RedisTemplate<String, String> getRedisTemplate() {
    return redisTemplate;
  }

  public RedisCacheManager getRedisCacheManager() {
    return redisCacheManager;
  }

  @Bean
  public KeyGenerator keyGenerator() {
    return new KeyGenerator() {
      @Override
      public Object generate(Object o, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.getClass().getName());
        sb.append("-");
        sb.append(method.getName());
        sb.append("-");
        for (Object param : params) {
            sb.append(param.toString());
        }
        return sb.toString();
      }
    };
  }
}