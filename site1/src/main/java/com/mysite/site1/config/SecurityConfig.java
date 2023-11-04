package com.mysite.site1.config;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    Logger logger = LoggerFactory.getLogger(SecurityConfig.class);


    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

     @Autowired
     private AuthenticationProvider authenticationProvider;

    //When application starts, spring secuirty looks for SecurityFilterChain bean


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        logger.info("Initializing Filter chain........");
        http
                .csrf()
                .disable()

                .authorizeHttpRequests((authz) -> {
                            try {
                                authz
                                        .requestMatchers("/users/register")
                                        .permitAll()
                                        .requestMatchers("/contents/**")
                                        .permitAll()
                                        .requestMatchers("/users/getAll")
                                        .permitAll()
                                        .requestMatchers("/users/authenticate")
                                        .permitAll()
//                                        .requestMatchers("/authenticate")
//                                        .permitAll()
//
                                        .anyRequest()
//                                        .denyAll()
                                        .authenticated()

                                        .and()
                                        .sessionManagement()
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                        .and()
                                        .authenticationProvider(authenticationProvider)
                                        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });

        return http.build();
    }
}