package com.example.user.interceptor;


import com.example.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//鉴权拦截器
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

   @Resource
   private JWTUtils jwtUtils;



   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



      //校验当前用户登录并且是管理员角色才能删除
      String authorization = request.getHeader("Authorization");
      //获得请求头(Authorization)
      if (!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer ")){
         //提取头中的认证信息
         String token = authorization.substring(7);

         //获得Jwt的载荷键值对
         Claims claims = jwtUtils.parseJWT(token);

         if(claims!=null && "admin".equals(claims.get("roles"))){
            //向request中添加载荷信息
            request.setAttribute("claims_admin",claims);
         }
         if(claims!=null && "user".equals(claims.get("roles"))){
            //向request中添加载荷信息
            request.setAttribute("claims_user",claims);
         }

      }

      return true;
   }
}
