package com.leepnujnooy.community2.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;

public class JwtTokenUtils {

    //Jwt 안에 secret 한 value 를 저장하기 위한 용도
    private final Key signingKey;
    //Jwt 안의 내용을 파싱(해석) 하는 용도
    private final JwtParser jwtParser;

    public JwtTokenUtils(@Value("${jwt.secret}")String jwtSecrets){
        this.signingKey = Keys.hmacShaKeyFor(jwtSecrets.getBytes());
        this.jwtParser = Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build();
    }

    public String createToken(){
        Claims claims = Jwts
                .claims()
                .setAudience();
    }


}
