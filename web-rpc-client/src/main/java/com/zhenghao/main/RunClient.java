package com.zhenghao.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.zhenghao.config.RmiServiceClientConfig;
import com.zhenghao.service.SpitterService;

public class RunClient {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RmiServiceClientConfig.class);
        SpitterService client = context.getBean("rmiProxyFactoryBean", SpitterService.class);
        client.getAllSpitters();
    }
}
