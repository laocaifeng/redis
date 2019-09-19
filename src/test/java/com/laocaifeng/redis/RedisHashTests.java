package com.laocaifeng.redis;

import com.laocaifeng.redis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisHashTests {
    @Autowired
    RedisUtil redisUtil;
    

    /**
     * 添加字段
     */
    @Test
    public void test() {
        redisUtil.hPut("user","name","tom");
    }
    /**
     * 添加多个字段
     */
    @Test
    public void test1() {
        Map<String,String>map = new HashMap<>();
        map.put("age","11");
        map.put("sex","男");
        redisUtil.hPutAll("user",map);
    }
    /**
     *仅当hashKey不存在时才设置
     */
    @Test
    public void test2() {
        System.out.println(redisUtil.hPutIfAbsent("user","name","tom"));
        System.out.println(redisUtil.hPutIfAbsent("user","emil","qq.com"));
    }
    /**
     *获取存储在哈希表中指定字段的值
     */
    @Test
    public void test3() {
        System.out.println(redisUtil.hGet("user","name"));
    }
    /**
     *获取所有给定字段的值
     */
    @Test
    public void test4() {
        System.out.println(redisUtil.hGetAll("user"));
    }
    /**
     *获取所有给定字段的值
     */
    @Test
    public void test5() {
        String [] arr = {"age","emil"};
        System.out.println(redisUtil.hMultiGet("user", CollectionUtils.arrayToList(arr)));
    }
    /**
     *删除一个或多个哈希表字段
     */
    @Test
    public void test6() {
        System.out.println(redisUtil.hDelete("user","name","age"));
    }
    /**
     *查看哈希表key中指定的字段是否存在
     */
    @Test
    public void test7() {
        System.out.println(redisUtil.hExists("user","name"));
        System.out.println(redisUtil.hExists("user","emil"));
    }
    /**
     *为哈希表key中指定字段的值增加increment
     */
    @Test
    public void test8() {
        System.out.println(redisUtil.hIncrBy("user","age",9));
        System.out.println(redisUtil.hIncrBy("user","age",-1));
    }
    /**
     *为哈希表key中指定字段的值增加increment
     */
    @Test
    public void test9() {
        System.out.println(redisUtil.hIncrByFloat("user","age",9.1));
        System.out.println(redisUtil.hIncrByFloat("user","age",-0.1));
    }
    /**
     *获取所有哈希表中的字段
     */
    @Test
    public void test10() {
        System.out.println(redisUtil.hKeys("user"));
    }
    /**
     *获取哈希表中字段的数量
     */
    @Test
    public void test11() {
        System.out.println(redisUtil.hSize("user"));
    }
    /**
     *获取哈希表中所有值
     */
    @Test
    public void test12() {
        System.out.println(redisUtil.hValues("user"));
    }

}
