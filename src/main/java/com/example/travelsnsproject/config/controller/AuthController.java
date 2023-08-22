package com.example.travelsnsproject.config.controller;

import com.example.travelsnsproject.config.service.OauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final OauthService oauthService;

    @GetMapping
    public Map<String,Object> SingUpAndLogin(
            @Param("email") String email,
            @Param("nickname") String nickName
    ){
        Map<String,String> map = new HashMap<>();
        map.put("id",email);
        map.put("name",nickName);
        return oauthService.loginCheck(map);
    }


}



