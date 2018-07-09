package com.zhenghao.config;

import com.zhenghao.service.SpitterService;
import com.zhenghao.service.SpitterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;


//@Configuration
public class RmiServiceServerConfig {

    // 注册服务bean
    @Bean
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }

    // 将服务bean 导出为 RMI服务
    @Bean
    public RmiServiceExporter rmiServiceExporter(SpitterService spitterService) {
        // 启用Java安全管理器
        // 可以加参数启动:
        //      -Djava.security.manager
        //      -Djava.security.policy="/Users/zhenghao/Documents/Workspace/IDEA/webrpc/web-rpc-server/src/main/java/rmi/config/java.policy"
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(spitterService);
        exporter.setServiceName("SpitterService");
        exporter.setServiceInterface(SpitterService.class);
//        rmiServiceExporter.setRegistryHost(""); //默认是绑定到本地的RMI注册表
//        rmiServiceExporter.setRegistryPort(1099); //默认端口是1099
        return exporter;
    }
}
