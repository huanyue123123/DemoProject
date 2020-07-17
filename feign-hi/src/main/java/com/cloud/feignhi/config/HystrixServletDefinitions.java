package com.cloud.feignhi.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixServletDefinitions {

    @Bean(name = "hystrixRegistrationBean")
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new HystrixMetricsStreamServlet(),"/metrics/hystrix.stream"
        );
        servletRegistrationBean.setName("hystrixServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
}
