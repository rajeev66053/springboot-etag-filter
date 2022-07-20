package com.java.etagfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class EtagFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtagFilterApplication.class, args);
    }

    @Bean
    ShallowEtagHeaderFilter shallowEtagHeaderFilter(){
        return new ShallowEtagHeaderFilter();
    }


    //For specific endpoint to apply etag information. To use this we have to comment out above ShallowEtagHeaderFilter bean
    @Bean
    FilterRegistrationBean<ShallowEtagHeaderFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<ShallowEtagHeaderFilter> bean = new FilterRegistrationBean<>(
                new ShallowEtagHeaderFilter()
        );
        bean.addUrlPatterns("/rest12/*");
        bean.setName("etagFilter");
        return bean;

    }

}