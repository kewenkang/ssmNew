package com.smartHouse.operation.service;

import com.smarthouse.operation.service.SmartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Auther: davidddl
 * @Date: 2018/5/2 01:55
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class smartTest {

    @Resource
    SmartService smartService;

    @Test
    public void smartTest1(){
        System.out.println(smartService.getSmartList());
    }
}
