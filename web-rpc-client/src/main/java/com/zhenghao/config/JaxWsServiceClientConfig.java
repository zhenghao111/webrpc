package com.zhenghao.config;

import com.zhenghao.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import java.net.MalformedURLException;
import java.net.URL;

//@Configuration
public class JaxWsServiceClientConfig {
    @Bean
    public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean() throws MalformedURLException {
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        proxy.setWsdlDocumentUrl(new URL("http://localhost:8080/SpitterService?wsdl"));
        proxy.setServiceName("spitterService");
        proxy.setPortName("spitterServiceHttpPort");
        proxy.setServiceInterface(SpitterService.class);
        proxy.setNamespaceUri("http://spitter.com");
        return proxy;
    }
}
