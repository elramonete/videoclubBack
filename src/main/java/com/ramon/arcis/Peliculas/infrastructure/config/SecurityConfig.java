package com.ramon.arcis.Peliculas.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
         httpSecurity.authorizeHttpRequests(request ->
                request.requestMatchers("/api/pelicula/**")
                        .permitAll() //permitimos todos aquellos q tengan /api/pelicula
                        .requestMatchers("/api/seguridad/**")
                        .authenticated() //para todos aquellos /api/seguridad que sean autentificados
                )
                 .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable()); //cuando es de tipo REST
                return httpSecurity.build();
    }
    }