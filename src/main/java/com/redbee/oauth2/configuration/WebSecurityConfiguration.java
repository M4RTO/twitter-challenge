package com.redbee.oauth2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserDetailsService customUserDetailService;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/images/**", "/js/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf()
      .and()
      .authorizeRequests()
        .antMatchers("/","/login","/logout.do", "/anon", "/health").permitAll()
        .antMatchers("/**").authenticated()
      .and()
        .formLogin()
          .loginProcessingUrl("/login.do")
            .usernameParameter("username")
            .passwordParameter("password")
            .failureUrl("/loginFailed")
          .loginPage("/login")
      .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"));
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.parentAuthenticationManager(authenticationManagerBean())
            .userDetailsService(customUserDetailService);

  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

}
