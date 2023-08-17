package com.example.travelsnsproject.config.aspect;

import com.example.travelsnsproject.config.exception.NoTokenException;
import com.example.travelsnsproject.config.exception.NotValidToken;
import com.example.travelsnsproject.config.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@RequiredArgsConstructor
public class TokenAspect {
    private final TokenService tokenService;

    @Before("@annotation(TokenCheck)")
    public void tokenCheck(){
        HttpServletRequest httpServletRequest =  ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String auth = httpServletRequest.getHeader("Authorization");

        if (auth==null){
            new NoTokenException("토큰없다");
        }else{
            Boolean check = tokenService.checkToken(auth);
            if (!check){
                new NotValidToken("유효하지 않은 토큰");
            }
        }
        //토큰 유효성도 검사해야함
    }
}
