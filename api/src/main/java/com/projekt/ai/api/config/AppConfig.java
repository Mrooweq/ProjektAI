package com.projekt.ai.api.config;

import com.projekt.ai.api.auth.AuthorizationWebMvcConfigurerAdapter;
import com.projekt.ai.api.auth.InternalContext;
import com.projekt.ai.api.auth.CustomFilter;
import com.projekt.ai.common.app.AppTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.servlet.DispatcherType;

/**
 * Created by Lenovo on 2017-11-23.
 */

@Configuration
public class AppConfig {

    @Autowired
    private AppTools appTools;

    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
    InternalContext internalContext(){
        return new InternalContext();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(DispatcherType.REQUEST,DispatcherType.FORWARD);
        registration.setMatchAfter(true);
        registration.setFilter(new CustomFilter(internalContext(), appTools));
        registration.setOrder(1);
        return registration;
    }

    @Bean
    AuthorizationWebMvcConfigurerAdapter authorizationWebMvcConfigurerAdapter(){
        return new AuthorizationWebMvcConfigurerAdapter(internalContext());
    }
}
