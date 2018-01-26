package com.projekt.ai.common.app;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lenovo on 2017-12-11.
 */

@Service
public class AppTools {
    public boolean isSecuredPath(HttpServletRequest request){
        String requestURI = request.getRequestURI();

        for (String securedPath : AppData.SECURED_PATHS) {
            if(requestURI.startsWith(securedPath))
                return true;
        }

        return false;
    }
}
