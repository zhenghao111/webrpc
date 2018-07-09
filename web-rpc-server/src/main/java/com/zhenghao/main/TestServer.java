package com.zhenghao.main;

import com.caucho.hessian.client.HessianProxyFactory;
import com.zhenghao.service.SpitterService;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.net.MalformedURLException;

public class TestServer {
    public static void main(String[] args) throws MalformedURLException {

        // 测试RMI服务端
//        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
//        proxy.setServiceUrl("rmi://localhost/SpitterService");
//        proxy.setServiceInterface(SpitterService.class);
        // 不知道怎么获取SpitterService对象
//        SpitterService spitterService = (SpitterService) proxy.
//        spitterService.getAllSpitters();

        // 测试Hessian服务端
        HessianProxyFactory proxy = new HessianProxyFactory();
        SpitterService spitterService = (SpitterService) proxy.create(SpitterService.class, "http://localhost:8080/server/spitter.service");
        // 是在服务端输出
        spitterService.getAllSpitters();
        spitterService.deleteSpittle(0);
        // 浏览器里直接用http://localhost:8080/server/spitter.service访问，HTTP Status 405 – Method Not Allowed说明服务端正常
    }
}
