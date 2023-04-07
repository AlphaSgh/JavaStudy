package com.ssgh;

import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.10.175", 6379);
        System.out.println(jedis.ping());
    }
}