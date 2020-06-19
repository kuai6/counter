package com.kuai6.counter.repository;

import com.kuai6.counter.RepositoryInterface;
import com.kuai6.counter.model.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepositoryImpl implements RepositoryInterface {
    private static final String KEY = "key";
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Count increase() throws IncreaseException {
        try {
            RedisConnectionFactory cf = redisTemplate.getConnectionFactory();
            if (cf == null) {
                throw new IncreaseException("Could't get redis connection factory");
            }
            RedisAtomicLong value = new RedisAtomicLong(KEY, cf);
            return new Count(value.incrementAndGet());
        } catch (NullPointerException e) {
            throw new IncreaseException(e);
        }
    }
}
