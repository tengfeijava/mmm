package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import redis.clients.jedis.Jedis;


@SpringBootTest
class JavaInformationplatformApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void Test1(){
//        String version = SpringVersion.getVersion();
//        String version1 = SpringBootVersion.getVersion();
    }
//    @Test
//    public void Test2(){
//        for (int i = 101; i < 200; i+=2) {
//             boolean f = true;
//            for (int j = 2; j < i; j++) {
//                if(i % j == 0){
//                    f = false;
//                    break;
//                }
//            }
//            if (!f){continue;}
//            System.out.println(" "+ i);
//        }
//    }
//       @Test
//        public void testJedis1(){
//            Jedis jedis = new Jedis("39.107.70.188", 6379);
//            jedis.auth("000000");
//            jedis.set("key2", "aaaaaa");
//            String key2 = jedis.get("key2");
//            System.out.println("获取到的key2为:"+key2);
//            jedis.close();
//        }

}
