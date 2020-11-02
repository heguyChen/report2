package com.dcseat.report.dao.seat;

import com.dcseat.report.util.PropertiesUtil;
import com.dcseat.report.util.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
class UsersTest {

    @Test
    void getActiveUsersByCorp() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Users users = (Users) applicationContext.getBean("users");
        String year = PropertiesUtil.getProperty("dc.year");
        String month = PropertiesUtil.getProperty("dc.month");
        String day = PropertiesUtil.getProperty("dc.day");
        String date = new StringBuilder(year).append("-").append(month).append("-").append(day).toString();
        Users users = SpringContextUtil.getBean("users");
        Integer num = users.getActiveUsersByCorp(98547771, date);
        System.out.println(num);
    }


}