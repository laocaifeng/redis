package com.laocaifeng.redis;

import com.laocaifeng.redis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisStringTests {
    @Autowired
    RedisUtil redisUtil;




    /**
     * 获取指定key的值
     */
    @Test
    public void test1() {
        System.out.println(redisUtil.get("key1"));
    }
    /**
     * 返回key中字符串值的子字符
     */
    @Test
    public void test2() {
        System.out.println(redisUtil.getRange("key1",0,2));
    }
    /**
     * 将key的值设为value，并返回key旧值
     */
    @Test
    public void test3() {
        System.out.println(redisUtil.getAndSet("key1","value2"));
    }
    /**
     *  判断指定的位置ASCII码的bit位是否为1。
     */
    @Test
    public void test4() {
        System.out.println(redisUtil.getBit("key1",1));
    }
    /**
     *  批量获取
     */
    @Test
    public void test5() {
        String [] arr = {"key1","a","b"};
        System.out.println(redisUtil.multiGet(new ArrayList<String>(CollectionUtils.arrayToList(arr))));
    }
    /**
     * 设置指定得key值
     */
    @Test
    public void test() {
        redisUtil.set("key1","value1");
    }
    /**
     * 设置指定位置上的ASCII码
     * 例如字符'a'的ASCII码是97，转为二进制是'01100001'，setBit方法就是把第offset位置上变成0或者1，true是1，false是0。
     */
    @Test
    public void test6() {
        redisUtil.setBit("key1",4,false);
    }

    /**
     * 将值value关联到key，并设置key过期时间
     */
    @Test
    public void test7() {
        redisUtil.setEx("key2","value2", 10,TimeUnit.MINUTES);
    }

    /**
     * 只有在 key 不存在时设置 key 的值
     */
    @Test
    public void test8() {
        redisUtil.setIfAbsent("key2","value4");
        redisUtil.setIfAbsent("key3","value3");
    }
    /**
     * 批量添加
     */
    @Test
    public void test9() {
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        redisUtil.multiSet(map);
    }
    /**
     * 批量添加，仅当所有key都不存在
     */
    @Test
    public void test10() {
        Map<String,String> map = new HashMap<>();
        map.put("6","6");
        map.put("5","5");
        map.put("4","4");
        redisUtil.multiSetIfAbsent(map);
    }
    /**
     * 追加到末尾
     */
    @Test
    public void test11() {
        redisUtil.append("1","2");
    }
    /**
     * 增加(自增长), 负数则为自减
     */
    @Test
    public void test12() {
        redisUtil.incrBy("1",1);
        redisUtil.incrBy("2",2);
        redisUtil.incrBy("4",-1);
    }
    /**
     * 增加(自增长), 负数则为自减
     */
    @Test
    public void test13() {
        redisUtil.incrByFloat("1",1.3);
        redisUtil.incrByFloat("2",2.9);
        redisUtil.incrByFloat("4",-1.5);
    }
    /**
     * 增加(自增长), 负数则为自减
     */
    @Test
    public void test14() {
        System.out.println(redisUtil.size("key3"));
    }
}
