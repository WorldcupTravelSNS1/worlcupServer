package com.example.travelsnsproject.config.service;


import com.example.travelsnsproject.config.entity.Member;
import com.example.travelsnsproject.domain.member.Repository.MemberRepository;
import com.example.travelsnsproject.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OauthService {
    private final TokenService tokenService;
    private final MemberService memberService;

    public String getAccessToken(String code){
        String uri = "https://oauth2.googleapis.com/token";
        String redirectUri = "http://localhost:8080/login/oauth/code/google";
        String clientId = "782445136437-gjq3co4n7slgd4k0lfo6u8hfb0mcnohu.apps.googleusercontent.com";
        String clientSecret = "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";

        WebClient webClient = WebClient.create(uri);

        Map response = webClient.post()
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("code", code)
                        .with("client_id", clientId)
                        .with("client_secret", clientSecret)
                        .with("redirect_uri", redirectUri)
                        .with("grant_type", "authorization_code"))
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        return (String) response.get("access_token");
    }

    public Map getUserInfo(String accessToken){
        WebClient webClient = WebClient.builder()
                .baseUrl("https://www.googleapis.com/oauth2/v2/userinfo")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer "+accessToken)
                .build();
        Map reponse = webClient.get()
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        return reponse;
    }

    public Map<String,Object> loginCheck(Map userInfo){
        Optional<Member> member1 = memberService.findByEmailId((String) userInfo.get("id"));
        Member member = member1.orElse(null);
        Map<String,Object> tokenAndMemberId = new HashMap<>();

        if (member != null){
            String token = tokenService.makeToken(member);
            tokenAndMemberId.put("token",token);
            tokenAndMemberId.put("id",member.getId());
        }else{
            tokenAndMemberId = signIn(userInfo);
        }

        return tokenAndMemberId;
    }

    public Map<String,Object> signIn(Map userInfo){
        Member member = memberService.memberSaveByUserInfo(userInfo);
        String token = tokenService.makeToken(member);
        Map<String,Object> map = new HashMap<>();
        map.put("id",member.getId());
        map.put("token", token);
        return map;
    }

}






