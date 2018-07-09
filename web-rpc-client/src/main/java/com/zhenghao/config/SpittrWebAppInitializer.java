package com.zhenghao.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// 方式1 自动创建DispatcherServlet、ContextLoaderListener加载Spring上下文、其他Spring上下文
public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootConfig.class,
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }


}

