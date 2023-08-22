package com.example.travelsnsproject.config.controller;


import com.example.travelsnsproject.config.service.OauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/login/oauth/code/google")
@RequiredArgsConstructor
public class OauthController {
    private final OauthService oauthService;

//    @GetMapping
//    public ModelAndView SignInAndLogin(@Param("code") String code) {
//        String accessToken = oauthService.getAccessToken(code);
//        Map userInfo = oauthService.getUserInfo(accessToken);
//        oauthService.loginCheck(userInfo);
//        ModelAndView mav = new ModelAndView("redirect:http://localhost:3000/api/v1/worldcup");
////        mav.setViewName("http://localhost:3000/api/v1/worldcup");
//        return mav;
//    }



}



