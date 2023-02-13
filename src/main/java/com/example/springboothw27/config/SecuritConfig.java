package com.example.springboothw27.config;

import com.example.springboothw27.repstiotry.AuthRepstory;
import com.example.springboothw27.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.swing.plaf.PanelUI;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecuritConfig {
    private final MyUserDetailsService service;
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(service);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }
  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
        return http.build();
    }
}
