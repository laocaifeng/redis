package com.laocaifeng.redis;

import com.laocaifeng.redis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisZsetTests {
    @Autowired
    RedisUtil redisUtil;
    

    /**
     * 设置指定得key值
     */
    @Test
    public void test() {
        redisUtil.zAdd("key1","value1",1);
        redisUtil.zAdd("key1","value2",2);
        redisUtil.zAdd("key1","value3",3);
        redisUtil.zAdd("key1","value4",4);
    }
    /**
     * 获取元素,小到大排序,s开始e结束位置
     */
    @Test
    public void test1() {
        System.out.println(redisUtil.zRange("key1",0,1));
    }
    /**
     * 获取集合元素, 并且把score值也获取
     */
    @Test
    public void test2() {
        System.out.println(redisUtil.zRangeWithScores("key1",0,1));
    }
    /**
     * 根据score范围查询元素,从小到大排序
     */
    @Test
    public void test3() {
        System.out.println(redisUtil.zRangeByScore("key1",0,3));
    }
    /**
     * 根据score范围查询元素,并返回score
     */
    @Test
    public void test4() {
        System.out.println(redisUtil.zRangeByScoreWithScores("key1",0,3));
    }
    /**
     * 根据score查询元素,s开始e结束位置
     */
    @Test
    public void test5() {
        System.out.println(redisUtil.zRangeByScoreWithScores("key1",0,3,0,3));
    }
    /**
     * 获取集合元素, 从大到小排序
     */
    @Test
    public void test6() {
        System.out.println(redisUtil.zReverseRange("key1",0,3));
    }
    /**
     * 获取元素,从大到小排序,并返回score
     */
    @Test
    public void test7() {
        System.out.println(redisUtil.zReverseRangeWithScores("key1",0,3));
    }
}
