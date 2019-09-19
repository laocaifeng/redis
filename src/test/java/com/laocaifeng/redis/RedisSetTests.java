package com.laocaifeng.redis;

import com.laocaifeng.redis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSetTests {
    @Autowired
    RedisUtil redisUtil;
    

    /**
     * 设置指定得key值
     */
    @Test
    public void test() {
        redisUtil.sAdd("set1","set1");
        redisUtil.sAdd("set1","set2");
        redisUtil.sAdd("set1","set3");
        redisUtil.sAdd("set1","set4");

        redisUtil.sAdd("set2","set1");
        redisUtil.sAdd("set2","set2");
        redisUtil.sAdd("set2","set3");
        redisUtil.sAdd("set2","set5");

        redisUtil.sAdd("set3","set1");
        redisUtil.sAdd("set3","set2");
        redisUtil.sAdd("set3","set3");
        redisUtil.sAdd("set3","set6");
    }
    /**
     * 获取集合所有元素

    @Test
    public void test() {
        redisUtil.sMembers("set1");
    }
     */
    /**
     * 获取集合大小
     */
    @Test
    public void test1() {
        System.out.println(redisUtil.sSize("set1"));
    }
    /**
     * 判断集合是否包含value
     */
    @Test
    public void test2() {
        System.out.println(redisUtil.sIsMember("set1","set2"));
    }
    /**
     * 随机获取集合中的一个元素
     */
    @Test
    public void test3() {
        System.out.println(redisUtil.sRandomMember("set1"));
    }
    /**
     * 随机获取集合count个元素
     */
    @Test
    public void test4() {
        System.out.println(redisUtil.sRandomMembers("set1",2));
    }
    /**
     * 	随机获取count个元素并去除重复的
     */
    @Test
    public void test5() {
        System.out.println(redisUtil.sDistinctRandomMembers("set1",2));
    }
    /**
     * 	移除
     */
    @Test
    public void test6() {
        System.out.println(redisUtil.sRemove("set1","set1","set2"));
    }
    /**
     * 	随机移除一个元素
     */
    @Test
    public void test7() {
        System.out.println(redisUtil.sPop("set1"));
    }
    /**
     * 	将key集合中value移到destKey中
     */
    @Test
    public void test8() {
        System.out.println(redisUtil.sMove("set1","set4","set2"));
    }

    /**
     * 	获取两个集合的交集
     */
    @Test
    public void test10() {
        System.out.println(redisUtil.sIntersect("set1","set2"));
    }
    /**
     * 	获取key集合与多个集合的交集
     */
    @Test
    public void test11() {
        String [] arr = {"set3","set2"};
        System.out.println(redisUtil.sIntersect("set1", CollectionUtils.arrayToList(arr)));
    }
    /**
     * 	key集合与oKey的交集存储到dKey中
     */
    @Test
    public void test12() {
        System.out.println(redisUtil.sIntersectAndStore("set1","set2","set4"));
    }
    /**
     * 	key与多个集合的交集存储到dKey中
     */
    @Test
    public void test9() {
        String [] arr = {"set3","set2"};
        System.out.println(redisUtil.sIntersectAndStore("set1",CollectionUtils.arrayToList(arr),"set5"));
    }


    /**
     * 	获取两个集合的并集
     */
    @Test
    public void test13() {
        System.out.println(redisUtil.sUnion("set1","set2"));
    }
    /**
     * 	获取key集合与多个集合的并集
     */
    @Test
    public void test14() {
        String [] arr = {"set3","set2"};
        System.out.println(redisUtil.sUnion("set1", CollectionUtils.arrayToList(arr)));
    }
    /**
     * 	key集合与oKey的并集存储到dKey中
     */
    @Test
    public void test15() {
        System.out.println(redisUtil.sUnionAndStore("set1","set2","set4"));
    }
    /**
     * 	key与多个集合的并集存储到dKey中
     */
    @Test
    public void test16() {
        String [] arr = {"set3","set2"};
        System.out.println(redisUtil.sUnionAndStore("set1",CollectionUtils.arrayToList(arr),"set5"));
    }




    /**
     * 	获取两个集合的差集
     */
    @Test
    public void test17() {
        System.out.println(redisUtil.sDifference("set1","set2"));
    }
    /**
     * 	获取key集合与多个集合的差集
     */
    @Test
    public void test18() {
        String [] arr = {"set3","set2"};
        System.out.println(redisUtil.sDifference("set1", CollectionUtils.arrayToList(arr)));
    }
    /**
     * 	key集合与oKey的差集存储到dKey中
     */
    @Test
    public void test19() {
        System.out.println(redisUtil.sDifference("set1","set2","set4"));
    }
    /**
     * 	key与多个集合的差集存储到dKey中
     */
    @Test
    public void test20() {
        String [] arr = {"set3","set2"};
        System.out.println(redisUtil.sDifference("set1",CollectionUtils.arrayToList(arr),"set5"));
    }
}
