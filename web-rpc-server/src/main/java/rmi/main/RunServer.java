package rmi.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rmi.config.RmiServiceServerConfig;

public class RunServer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(RmiServiceServerConfig.class);

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("rmi.xml");

    }
}
