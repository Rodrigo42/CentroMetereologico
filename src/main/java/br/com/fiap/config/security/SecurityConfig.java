package br.com.fiap.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private VerificarToken verificarToken;
    @Bean
    public SecurityFilterChain filtrarCadeiaDeSeguranca(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/chuva/listar", "/api/seca/listar", "/api/terremoto/listar", "/api/qldar/listar","/api/qldagua/listar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/chuva/add", "/api/seca/add", "/api/terremoto/add", "/api/qldar/add", "/api/qldagua/add").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/chuva/put", "/api/seca/put", "/api/terremoto/put", "/api/qldar/put", "/api/qldagua/put").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/chuva/delete", "/api/seca/delete", "/api/terremoto/delete", "/api/qldar/delete", "/api/qldagua/delete").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated())
                .addFilterBefore(verificarToken, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception{

        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

}
