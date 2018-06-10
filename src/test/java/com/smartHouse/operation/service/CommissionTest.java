package com.smartHouse.operation.service;


import com.smarthouse.operation.dao.CommissionDAO;
import com.smarthouse.operation.dataobject.Sale;
import com.smarthouse.operation.service.CommissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class CommissionTest {
    @Autowired
    CommissionService commissionService;
    @Autowired
    CommissionDAO commissionDAO;

    @Test
    public void test(){
        List<Sale > sale = commissionDAO.getSalesBySalePerson(4);
        System.out.println(sale.toString());

    }

    @Test
    public void test1(){
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -1);
        Date time = date.getTime();
        System.out.println(time.toString());

    }

}
