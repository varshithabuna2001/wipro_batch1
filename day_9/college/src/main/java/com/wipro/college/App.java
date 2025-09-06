package com.wipro.college;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        College college = ctx.getBean("college", College.class);

        System.out.println("College Bean Loaded: " + college);
    }
}
