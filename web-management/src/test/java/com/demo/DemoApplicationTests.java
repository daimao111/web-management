package com.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testUUid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * 生成JWT
     */
    @Test
    public void testGenJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");

        String jwt = Jwts.builder().
                signWith(SignatureAlgorithm.HS256, "hywhywhyw") //签名算法以及签名密钥
                .setClaims(claims)    //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))  //设置有效时长为一小时
                .compact();

        System.out.println(jwt);
    }

    /**
     * 解码JWT
     */
    @Test
    public void testParseJWT() {
        Claims claims = Jwts.parser()
                .setSigningKey("hywhywhyw")     //指定签名密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTY5NDIxMTA3MH0." +   //解析令牌
                        "bMdCpGdzyXTS0EcxdKF18vdpU78i3Iia0FbwzgTWsi8")      //解析令牌
                .getBody();
        System.out.println(claims);
    }
}
