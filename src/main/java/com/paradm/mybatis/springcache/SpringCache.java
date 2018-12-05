package com.paradm.mybatis.springcache;

import java.util.concurrent.Callable;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;

public class SpringCache implements Cache {
  private RedisTemplate<String, Object> redisTemplate;
  private String name;
  
  public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Object getNativeCache() {
    return this.redisTemplate;
  }

  @Override
  public ValueWrapper get(Object key) {
    final String keyf = key.toString();
    Object object;
    object = redisTemplate.execute((RedisCallback<Object>) connection -> {
      byte[] key1 = keyf.getBytes();
      byte[] value = connection.get(key1);
      if (value == null) {
        return null;
      }
      return SerializationUtils.deserialize(value);
    });
    return (object != null ? new SimpleValueWrapper(object) : null);
  }

  @Override
  public <T> T get(Object key, Class<T> type) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T get(Object key, Callable<T> valueLoader) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void put(Object key, Object value) {
    final String keyf = key.toString();
    final Object valuef = value;
    final long liveTime = 86400;
    redisTemplate.execute((RedisCallback<Long>) connection -> {
      byte[] keyb = keyf.getBytes();
      byte[] valueb = SerializationUtils.serialize(valuef);
      connection.set(keyb, valueb);
      if (liveTime > 0) {
        connection.expire(keyb, liveTime);
      }
      return 1L;
    });
  }

  @Override
  public ValueWrapper putIfAbsent(Object key, Object value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void evict(Object key) {
    final String keyf = key.toString();
    redisTemplate.execute((RedisCallback<Long>) connection -> connection.del(keyf.getBytes()));
  }

  @Override
  public void clear() {
    redisTemplate.execute((RedisCallback<String>) connection -> {
      connection.flushDb();
      return "ok";
    });
  }

}
