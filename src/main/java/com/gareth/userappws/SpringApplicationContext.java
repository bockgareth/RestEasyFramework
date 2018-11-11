package com.gareth.userappws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContext {

    static ApplicationContext ctx = new ClassPathXmlApplicationContext("databaseContext.xml");

    public static <T> T getBean(String bean, Class<T> tClass) {
        return ctx.getBean(bean, tClass);
    }
}
