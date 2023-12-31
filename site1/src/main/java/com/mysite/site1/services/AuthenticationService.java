package com.mysite.site1.services;


import com.mysite.site1.models.User;
import com.mysite.site1.repository.UserRepository;
import com.mysite.site1.securityModels.AuthenticationRequest;
import com.mysite.site1.securityModels.AuthenticationResponse;
import com.mysite.site1.securityModels.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    Logger logger = LogManager.getLogger(AuthenticationService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        boolean emailAlreadyExists = userRepository.existsByEmail(request.getEmail());

        if(!emailAlreadyExists){
            User user = new User();
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);
            var jwtToken = jwtService.generateToken(user);
            logger.info("User Registered");

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message(null).build();

        }
        else {
            return AuthenticationResponse.builder()
                    .token(null)
                    .message("Email already in use").build();
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        logger.info("Initialing Authentication.......");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        logger.info("User's email: " + user.getEmail());
        var jwtToken = jwtService.generateToken(user);
        logger.info("JWT token Generated");
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
