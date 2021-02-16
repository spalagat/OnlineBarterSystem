package com.example.onlinebartersystem.EntryPointEXceptions;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;


//import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public static String message;

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        if(message==null){
            message="Entry ForBidden";
        }
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
//        res.getWriter().write(
//                .put("timestamp", DateGenerator.getDate())
//                .put("status", 403)
//                .put("message", message)
//                .build());
        res.getWriter().write(message);
    }

}
