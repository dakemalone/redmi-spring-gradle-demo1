package com.example.demo.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.http.HttpRequest;

/**
 * @author dake malone
 * @date 2023年02月02日 上午 11:49
 */
@Configuration
public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String origin = request.getHeader("Origin");
        if (StringUtils.isNotBlank(origin)) {
            response.setHeader("Access-Control-Allow-Origin",origin);
        }

        String headers = request.getHeader("Access-Control-Request-Headers");
        if(StringUtils.isNotBlank(headers)) {
            response.setHeader("Access-Control-Allow-Headers", headers);
            response.setHeader("Access-Control-Expose-Headers", headers);
        }


        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(req, res);


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
