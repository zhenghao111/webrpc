package rmi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import rmi.service.SpitterService;
import rmi.service.SpitterServiceImpl;


@Configuration
public class RmiServiceServerConfig {

    @Bean
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }

    //将service bean转变为RMI服务
    @Bean
    public RmiServiceExporter rmiServiceExporter(SpitterService spitterService) {
        //启用Java安全管理器，可以加参数启动-Djava.security.manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(spitterService);
        rmiServiceExporter.setServiceName("SpitterService");
        rmiServiceExporter.setServiceInterface(SpitterService.class);
//        rmiServiceExporter.setRegistryHost(""); //默认是绑定到本地的RMI注册表
//        rmiServiceExporter.setRegistryPort(1099); //默认端口是1099
        return rmiServiceExporter;
    }
}
