package com.projekt.ai.api.auth;

import com.projekt.ai.common.app.AppData;
import com.projekt.ai.common.app.BookstoreAppException;
import com.projekt.ai.common.app.AppTools;
import com.projekt.ai.common.app.Dictionary;
import com.projekt.ai.dal.domain.enums.Role;
import com.projekt.ai.dal.domain.enums.RoleParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;

/**
 * Created by Lenovo on 2017-11-23.
 */
public class CustomFilter extends OncePerRequestFilter {

    private InternalContext internalContext;
    private AppTools appTools;

    public CustomFilter(InternalContext internalContext, AppTools appTools) {
        this.internalContext = internalContext;
        this.appTools = appTools;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(appTools.isSecuredPath(request)){
            String token = request.getHeader("access_token");

            if(!StringUtils.isEmpty(token))
                parseJSON(token);
            else
                throw new BookstoreAppException(Dictionary.TOKEN_IS_NOT_SET);
        }

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8000");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Access-Control-Allow-Origin, Access-Control-Allow-Credentials");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void parseJSON(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(AppData.JWT_KEY))
                .parseClaimsJws(token).getBody();

        String username = (String) claims.get("username");
        Role role = RoleParser.getRoleByName((String)claims.get("role"));

        internalContext.setUserName(username);
        internalContext.setRole(role);
    }
}
