package com.laocaifeng.redis;

import com.laocaifeng.redis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisListTests {
    @Autowired
    RedisUtil redisUtil;
    

    /**
     * 存储在list头部
     */
    @Test
    public void test() {
        redisUtil.lLeftPush("list1","a");
    }

    /**
     * 存储在list头部
     */
    @Test
    public void test1() {
        redisUtil.lLeftPushAll("list1","a","b","c");
    }

    /**
     * 存储在list头部
     */
    @Test
    public void test2() {
        String [] arr = {"d","e","f"};
        redisUtil.lLeftPushAll("list1", CollectionUtils.arrayToList(arr));
    }

    /**
     * 当list存在的时候才加入
     */
    @Test
    public void test3() {
        redisUtil.lLeftPushIfPresent("list1","g");
        redisUtil.lLeftPushIfPresent("list2","g");
    }

    /**
     * 如果pivot存在,再pivot前面添加
     */
    @Test
    public void test4() {
        redisUtil.lLeftPush("list1","g","1");
        redisUtil.lLeftPush("list1","h","1");
    }



    /**
     * 存储在list尾部
     */
    @Test
    public void test5() {
        redisUtil.lRightPush("list1","a");
    }

    /**
     * 存储在list尾部
     */
    @Test
    public void test6() {
        redisUtil.lRightPushAll("list1","a","b","c");
    }

    /**
     * 存储在list尾部
     */
    @Test
    public void test7() {
        String [] arr = {"d","e","f"};
        redisUtil.lRightPushAll("list1", CollectionUtils.arrayToList(arr));
    }

    /**
     * 当list存在的时候才加入
     */
    @Test
    public void test8() {
        redisUtil.lRightPushIfPresent("list1","g");
        redisUtil.lRightPushIfPresent("list2","g");
    }

    /**
     * 如果pivot存在,再pivot后面添加
     */
    @Test
    public void test9() {
        redisUtil.lRightPush("list1","g","1");
        redisUtil.lRightPush("list1","h","1");
    }
    /**
     * 通过索引设置列表元素的值
     */
    @Test
    public void test10() {
        redisUtil.lSet("list1",0,"1");
    }
    /**
     * 通过索引获取列表中的元素
     */
    @Test
    public void test11() {
        System.out.println(redisUtil.lIndex("list1",1));
    }
    /**
     * 获取列表指定范围内的元素
     */
    @Test
    public void test12() {
        System.out.println(redisUtil.lRange("list1",0,4));
    }

    /**
     * 移出并获取列表的第一个元素
     */
    @Test
    public void test13() {
        System.out.println(redisUtil.lLeftPop("list1"));
    }

    /**
     * 移出并获取第一个元素,没有则阻塞直到超时或有为止
     */
    @Test
    public void test14() {
        System.out.println(redisUtil.lBLeftPop("list1",3, TimeUnit.SECONDS));
    }

    /**
     * 移除并获取列表最后一个元素
     */
    @Test
    public void test15() {
        System.out.println(redisUtil.lRightPop("list1"));
    }

    /**
     * 移出并获取最后个元素,没有则阻塞直到超时或有为止
     */
    @Test
    public void test16() {
        System.out.println(redisUtil.lBRightPop("list1",3, TimeUnit.SECONDS));
    }

    /**
     * 移除最后一个元素并加到另一个列表并返回
     */
    @Test
    public void test17() {
        System.out.println(redisUtil.lRightPopAndLeftPush("list1","list2"));
    }

    /**
     * 移除最后个元素并加到另个列表并返回,阻塞超时或有
     */
    @Test
    public void test18() {
        System.out.println(redisUtil.lBRightPopAndLeftPush("list1", "list2", 3, TimeUnit.SECONDS));
    }

    /**
     * 删除集合中值等于value得元素
     *  index=0, 删除所有值等于value的元素; index>0, 从头部开始删除第一个值等于value的元素;
     * 	index<0, 从尾部开始删除第一个值等于value的元素;
     */
    @Test
    public void test19(){
        System.out.println(redisUtil.lRemove("list1",2,"1"));
    }


    /**
     * 裁剪list
     */
    @Test
    public void test20() {
       redisUtil.lTrim("list1",0,4);
    }

    /**
     * 获取列表指定范围内的元素
     */
    @Test
    public void test21() {
        System.out.println(redisUtil.lLen("list1"));
    }


}
