package com.zhenghao.main;

import com.zhenghao.config.HessianServiceClientConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.zhenghao.config.RmiServiceClientConfig;
import com.zhenghao.service.SpitterService;

public class RunClient {


    public static void main(String[] args) {

        // 测试RMI客户端
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(RmiServiceClientConfig.class);
//        SpitterService client = context.getBean("rmiProxyFactoryBean", SpitterService.class);
//        client.getAllSpitters();

        // 测试Hessian客户端
        // 在服务端输出结果
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HessianServiceClientConfig.class);
        SpitterService client = context.getBean("hessianProxyFactoryBean", SpitterService.class);
        client.getAllSpitters();
    }
}
