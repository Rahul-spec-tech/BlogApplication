package com.example.PrivateBlogApplication.service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        boolean isPrivate = authentication.getAuthorities().stream()
//                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_PRIVATE"));
//        if (isPrivate) {
//            setDefaultTargetUrl("/private/home");
//        } else {
//            setDefaultTargetUrl("/public/home");
//        }
//        super.onAuthenticationSuccess(request, response, authentication);

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String redirectURL = request.getContextPath();

                if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_PRIVATE"))) {
                    redirectURL = "/home/private";
                } else if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_PUBLIC"))) {
                    redirectURL = "/home/public";
                }

                response.sendRedirect(redirectURL);
            }
        
//		UserRoleService userDetails = (UserRoleService) authentication.getPrincipal();
//        String redirectURL = request.getContextPath();
//
//        if (userDetails.getRoles().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
//            redirectURL = "/admin/home";
//        } else if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
//            redirectURL = "/user/home";
//        }
//
//        response.sendRedirect(redirectURL);
    }

