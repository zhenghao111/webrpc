package com.zhenghao.main;

import com.zhenghao.config.RmiServiceServerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunServer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RmiServiceServerConfig.class);

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("rmi.xml");

    }
}
