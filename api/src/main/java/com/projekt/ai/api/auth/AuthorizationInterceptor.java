package com.projekt.ai.api.auth;

import com.projekt.ai.common.app.Dictionary;
import com.projekt.ai.dal.domain.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lenovo on 2017-12-11.
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private InternalContext internalContext;

    public AuthorizationInterceptor(InternalContext internalContext) {
        this.internalContext = internalContext;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Secured secured = handlerMethod.getMethodAnnotation(Secured.class);
        Role userRole = internalContext.getRole();

        if(secured != null){
            Role[] allowedRoles = secured.value();

            if(userRole == Role.ADMIN)
                return true;

            for (Role allowedRole : allowedRoles) {
               if(userRole == allowedRole)
                   return true;
            }

            response.sendError(HttpServletResponse.SC_FORBIDDEN, Dictionary.USER_HAS_NO_ACCESS);
            return false;
        }

        return true;
    }
}
