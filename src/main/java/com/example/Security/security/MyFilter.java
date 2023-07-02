package com.example.Security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // để định nghĩa đây là 1 Component- thành phần để Spring khởi tạo
// trong java thì có 2 loại Filter,Intercepter- là những bộ chặn URL
public class MyFilter extends OncePerRequestFilter {
    //@Autowired
    JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("vào đây");
        String token = request.getHeader("token");
        if(token != null){
            System.out.println(" = Token nhận là:   " + token);
            String role = jwtTokenProvider.getClaimFromToken("roleX", token);
            System.out.println("get role from Token:  " + role);
            String name = jwtTokenProvider.getClaimFromToken("nameX", token);
            System.out.println("get Name from Token:  " + name);
            String subject = jwtTokenProvider.getSubjectFromToken(token);
            System.out.println("get Name from Token:  " + subject);
        }

//        System.out.println("++Di qua toi bo loc===");
//        response.addHeader("token","abc.xyz");
//        String token9 = request.getHeader("token");
//        if(token!=null){
//            System.out.println("token:"+token);
//        }
        filterChain.doFilter(request,response);
//    }


    }
}
