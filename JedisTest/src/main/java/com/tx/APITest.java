package com.tx;

import redis.clients.jedis.Jedis;

public class APITest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.101.17.160",6379);
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");

        
    }
}
