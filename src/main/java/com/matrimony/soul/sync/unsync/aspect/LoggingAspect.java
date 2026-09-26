package com.matrimony.soul.sync.unsync.aspect;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect implements LogoutHandler, AuthenticationEntryPoint {

    private static final Logger logger = Logger.getLogger("LoggingAspect");

    @PostConstruct
    public void logStartup(){
        logger.info("Application Started Successfully");
    }

    @Before("execution(* com.matrimony.soul.sync.unsync.api..*(..))")
    public void log(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            logger.info("unknown user");
        }
        else {
            logger.info(authentication.getName());
        }
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.warning("Unauthorized access: " + request.getMethod() + " " + request.getRequestURI());
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, @Nullable Authentication authentication) {
        if(authentication != null){
            logger.info("Uses logged out : " + authentication.getName());
        }
    }
}
