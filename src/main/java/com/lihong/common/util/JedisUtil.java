package com.lihong.common.util;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class JedisUtil implements ApplicationContextAware{
     private static  ApplicationContext APPLICATION_CONTEXT;
     private static  JedisPool JEDIS_POOL;
     private static  Jedis JEDIS;
      
    public void init(){
        JEDIS_POOL = (JedisPool)APPLICATION_CONTEXT.getBean("jedisPool");
        JEDIS = JEDIS_POOL.getResource();
    }
    
    public static String addList(String name,List value,long time){
        JEDIS.del(name);
        return JEDIS.set(name.getBytes(),  SerializeUtil.serialize(value),"NX".getBytes(),"EX".getBytes(),time);   
    }
    
    public static List getList(String name){
        return (List) SerializeUtil.unserialize(JEDIS.get(name.getBytes()));   
    }

 
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
        init();
    }

}
