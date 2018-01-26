package com.projekt.ai.api.auth;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Lenovo on 2017-12-11.
 */
public class AuthorizationWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    private InternalContext internalContext;

    public AuthorizationWebMvcConfigurerAdapter(InternalContext internalContext) {
        this.internalContext = internalContext;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(new AuthorizationInterceptor(internalContext))
                .addPathPatterns("/**");
    }
}