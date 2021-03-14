package com.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;


@ConfigurationProperties("jwt.config")
public class JWTUtils {
   // jwt.config.key 读取该配置值到key属性中
   private String key;
   //jwt.config.ttl 读取该配置值到ttl属性中
   private Long ttl;

   //颁发认证信息
   public String createJWT(String username,String roles){

      return Jwts.builder()
         .signWith(SignatureAlgorithm.HS256,key)//指定密钥
         .setSubject(username)
         .claim("roles",roles)
         .setIssuedAt(new Date())
         .setExpiration(new Date(System.currentTimeMillis()+ttl))
         .compact();

   }
   //解析认证信息
   public Claims parseJWT(String jwt){
      return Jwts.parser()
         .setSigningKey(key)
         .parseClaimsJws(jwt)
         .getBody();
   }





   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   public Long getTtl() {
      return ttl;
   }

   public void setTtl(Long ttl) {
      this.ttl = ttl;
   }
}
