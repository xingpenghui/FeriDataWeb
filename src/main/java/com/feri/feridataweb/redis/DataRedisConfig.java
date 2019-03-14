package com.feri.feridataweb.redis;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *@Author feri
 *@Date Created in 2019/3/14 10:15
 */
@Configuration
public class DataRedisConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Bean
    public RedisTemplate createRT(){
        RedisTemplate<String,Object> redisTemplate =new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    //新增字符串
    public void save(String key,String value){
         redisTemplate.opsForValue().set(key,value);
    }
    //新增Hash
    public void save(String key,Map<String,Object> map){
        redisTemplate.opsForHash().putAll(key,map);
    }
    //新增List
    public void save(String key,List<Object> list){
        redisTemplate.opsForList().leftPushAll(key,list);
    }
    //新增Set
    public void save(String key, Object[] set){
        redisTemplate.opsForSet().add(key,set);
    }


}
