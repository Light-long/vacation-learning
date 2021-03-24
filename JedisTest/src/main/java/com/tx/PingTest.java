package com.tx;

import redis.clients.jedis.Jedis;

public class PingTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.101.17.160",6379);
        System.out.println(jedis.ping());
    }
}
