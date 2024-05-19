package com.communicators.welltalk.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.AuthenticationResponse;
import com.communicators.welltalk.Entity.UserEntity;
import com.communicators.welltalk.Repository.UserRepository;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(UserEntity request) {
        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setIdNumber(request.getIdNumber());
        user.setImage(request.getImage());
        user.setDateOfCreation(request.getDateOfCreation());
        user.setDateOfModification(request.getDateOfModification());
        user.setRole(request.getRole());
        user.setIsDeleted(request.getIsDeleted());
        user.setInstitutionalEmail(request.getInstitutionalEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setCustomRole(request.getCustomRole());

        user = userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(UserEntity request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getInstitutionalEmail(), request.getPassword()

                ));

        UserEntity user = userRepository.findByInstitutionalEmail(request.getInstitutionalEmail());
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);

    }

}
