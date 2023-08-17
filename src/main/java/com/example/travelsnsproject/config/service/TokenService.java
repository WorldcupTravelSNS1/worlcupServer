package com.example.travelsnsproject.config.service;

import com.example.travelsnsproject.config.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.Map;


@Service
public class TokenService {
    @Value("${secret.key}")
    private String secretkey;

    public String makeToken(Member member){
        SecretKeySpec k=getKey();
        String compact= Jwts.builder()
                .claim("name",member.getName())
                .claim("id",member.getId())
                .signWith(k)
                .compact();
        return compact;
    }

    public SecretKeySpec getKey(){
        SignatureAlgorithm h=SignatureAlgorithm.HS256;
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretkey.getBytes(),h.getJcaName());
        return secretKeySpec;
    }

    public Map<String, Object> getClaims(String token){
//        SecretKeySpec key = getKey();
        return (Claims) Jwts.parserBuilder()
                .setSigningKey(secretkey.getBytes())
                .build()
                .parse(token)
                .getBody();
    }

    public Boolean checkToken(String token){

        try {Jwts.parserBuilder()
                .setSigningKey(secretkey.getBytes())
                .build()
                .parse(token);
                return true;}
        catch (Exception e){
            return false;
        }
    }


}
