package rmi.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rmi.config.RmiServiceClientConfig;
import rmi.service.SpitterService;

public class RunClient {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RmiServiceClientConfig.class);
        SpitterService client = context.getBean("rmiProxyFactoryBean", SpitterService.class);
        client.getAllSpitters();
    }
}
