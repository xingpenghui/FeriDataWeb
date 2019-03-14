package com.feri.feridataweb.redis;

import com.feri.feridataweb.common.SystemConst;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *@Author feri
 *@Date Created in 2019/3/14 09:35
 */
public class Jedis_Main {
    public static void main(String[] args) {
        //1、创建对象
//        JedisPool jedisPool=new JedisPool(SystemConst.RHOST,SystemConst.RPORT);
//        Jedis jedis1=jedisPool.getResource();
        Jedis jedis=new Jedis(SystemConst.RHOST,SystemConst.RPORT);
        //2、认证

        jedis.auth("qfjava");
        //3、操作
        //string
        jedis.set("s1807","我们做到不睡觉");
        System.out.println(jedis.get("s1807"));
        //list
        jedis.lpush("l1807","Java","大数据","AI","行业顶尖");
        System.out.println(jedis.lrange("l1807",0,jedis.llen("l1807")));
        //4、关闭
        jedis.close();

    }
}
