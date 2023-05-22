package com.example.redissample.service;

import com.example.redissample.dto.bodyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    String groupKey = "MainKey";

    public void saveData(String key, bodyDTO value){
        key = key+groupKey;
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 60, TimeUnit.SECONDS);
    }

    public Object getData(String key){
        key = key+groupKey;
        return redisTemplate.opsForValue().get(key);
    }

    public void updateData(String key,bodyDTO value){
        key = key+groupKey;
        redisTemplate.opsForValue().set(key, value);
    }

    public void deleteData(String key){
        key = key+groupKey;
        redisTemplate.delete(key);
    }

}
