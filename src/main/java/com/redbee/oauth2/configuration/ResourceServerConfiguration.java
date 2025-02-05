//package com.redbee.oauth2.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//
//@EnableResourceServer
//@Configuration
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//  @Autowired
//  AuthenticationManager authenticationManager;
//
//
//  @Override
//  public void configure(HttpSecurity http) throws Exception {
//    http
//            .requestMatchers()
//            .antMatchers("/api/**")
//            .and()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read') and hasRole('ROLE_ADMIN')")
//            .anyRequest().authenticated()
//            .and()
//            .exceptionHandling()
//            .accessDeniedHandler(new OAuth2AccessDeniedHandler());
//  }
//
//  @Override
//  public void configure(ResourceServerSecurityConfigurer resources)throws Exception{
//    resources.resourceId("client_api");
//  }
//
//
//
//
//
//
//}
