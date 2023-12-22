package com.producer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
                .csrf().disable()
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/user/**","/h2-console","/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults());
                //.addFilterAfter(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();

    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers( new AntPathRequestMatcher("/user/**")).permitAll()
                        .requestMatchers( new AntPathRequestMatcher("/user")).permitAll()
                        .requestMatchers( new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .requestMatchers( new AntPathRequestMatcher("/h2-console")).permitAll()
                        .anyRequest().authenticated())
                .httpBasic();
        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


}
