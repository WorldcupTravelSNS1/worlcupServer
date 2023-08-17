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
    public String loginCheck(Map userInfo){
        Optional<Member> member1 = memberService.findByEmailId((String) userInfo.get("id"));
        Member member = member1.orElse(null);
        String token = null;
        if (member != null){
            token = tokenService.makeToken(member);
        }else{
            token = signIn(userInfo);
        }
        return token;
    }

    public String signIn(Map userInfo){
        Member member = memberService.memberSaveByUserInfo(userInfo);
        return tokenService.makeToken(member);
    }

}
