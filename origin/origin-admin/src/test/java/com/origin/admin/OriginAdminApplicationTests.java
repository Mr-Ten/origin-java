package com.origin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class OriginAdminApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testRedis(){
        Jedis jedis = new Jedis("47.110.32.58", 6379);
        //jedis.auth("123456");
        System.out.println(jedis.getClient().getPort());
        System.out.println(jedis.ping());
    }

}
