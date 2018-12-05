package com.paradm.mybatis.rediscache;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;

public class RedisCache implements Cache {
  private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);
  private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private String id = null; // cache instance id
  private static RedisTemplate<String, Object> redisTemplate;
  private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis expire time
  
  public RedisCache(String id) {
    if (id == null) {
      throw new IllegalArgumentException("Cache instances require an ID");
    }
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void putObject(Object key, Object value) {
    if (value != null) {
      ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
      opsForValue.set(key.toString(), value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
      logger.debug("Put query result to redis");
    }
  }

  @Override
  public Object getObject(Object key) {
    if (key != null) {
      ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
      logger.debug("Get cached query result from redis");
      return opsForValue.get(key.toString());
    }
    return null;
  }

  @Override
  public Object removeObject(Object key) {
    if (key != null) {
      redisTemplate.delete(key.toString());
      logger.debug("Remove cached query result from redis");
    }
    return null;
  }

  @Override
  public void clear() {
    /*redisTemplate.execute((RedisCallback<String>) connection -> {
      connection.flushDb();
      return null;
    });*/
    try {
      Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
      if (!CollectionUtils.isEmpty(keys)) {
        redisTemplate.delete(keys);
      }
    } catch (Exception e) {
    }
    logger.debug("Clear all the cached query result from redis");
  }

  @Override
  public int getSize() {
    Long size = (Long) redisTemplate.execute(new RedisCallback<Long>() {
      @Override
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.dbSize();
      }
    });
    return size.intValue();
  }

  @Override
  public ReadWriteLock getReadWriteLock() {
    return readWriteLock;
  }

  public static void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
    RedisCache.redisTemplate = redisTemplate;
  }
}
