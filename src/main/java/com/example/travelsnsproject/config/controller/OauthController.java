package com.example.travelsnsproject.config.controller;


import com.example.travelsnsproject.config.service.OauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/login/oauth/code/google")
@RequiredArgsConstructor
public class OauthController {
    private final OauthService oauthService;

    @GetMapping
    public String SignInAndLogin(@Param("code") String code){
        String accessToken = oauthService.getAccessToken(code);
        Map userInfo = oauthService.getUserInfo(accessToken);
        return oauthService.loginCheck(userInfo);
    }



}
