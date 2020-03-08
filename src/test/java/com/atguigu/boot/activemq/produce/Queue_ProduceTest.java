package com.atguigu.boot.activemq.produce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Queue_ProduceTest {
    @Resource
    private Queue_Produce queue_produce;

    @Test
    public void testSend() throws Exception{
        queue_produce.producerMsg();
        System.out.println("********测试成功！");
    }

    @Test
    public void test01(){
        System.out.println("***************");
    }
}