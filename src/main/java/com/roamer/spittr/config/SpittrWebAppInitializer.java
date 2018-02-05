package com.roamer.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * 初始化配置Spring容器
 *
 * @author roamer
 * @version V1.0
 * @date 2018/1/10
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //要求ContextLoaderListener启动时使用指定的配置类中定义的bean
        //ContextLoaderListener要加载应用中的其他bean。这些bean通常是驱动应用后端的中间层和数据层组件
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //要求DispatcherServlet启动时使用指定的配置类中定义的bean
        //DispatcherServlet加载包含Web组件的bean，如控制器、视图解析器以及处理器映射
        return new Class[]{WebConfig.class, TilesConfig.class, ThymeleafConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //处理进入应用的所有请求
        return new String[]{"/"};
    }

    /**
     * DispatcherServlet注册到Servlet容器中之后，就会调用customizeRegistration()，
     * 并将Servlet注册后得到的Registration.Dynamic传递进来，
     * 通过重载customizeRegistration()方法，我们可以对DispatcherServlet进行额外的配置
     * <p>
     * customizeRegistration()方法中的ServletRegistration.Dynamic，
     * 能够完成多项任务，包括通过调用setLoadOnStartup()设置load-on-startup优先级，
     * 通过setInitParameter()设置初始化参数，
     * 通过调用setMultipartConfig()配置Servlet 3.0对multipart的支持
     * </p>
     *
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //限制文件的大小不超过2MB，整个请求不超过4MB，而且所有的文件都要写到磁盘
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads", 2097152, 4194304, 0));
    }


}
