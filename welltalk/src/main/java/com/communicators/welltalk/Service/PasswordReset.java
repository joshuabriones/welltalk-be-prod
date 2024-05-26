package com.communicators.welltalk.Service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Entity.UserEntity;
import com.communicators.welltalk.Repository.PasswordResetTokenRepository;
import com.communicators.welltalk.Entity.PasswordResetTokenEntity;
import com.communicators.welltalk.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class PasswordReset {
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createPasswordResetTokenForUser(UserEntity user, String token) {
        PasswordResetTokenEntity myToken = new PasswordResetTokenEntity();
        myToken.setUser(user);
        myToken.setToken(token);
        myToken.setExpiryDate(calculateExpiryDate(24 * 60)); // Token expires in 24 hours
        passwordResetTokenRepository.save(myToken);
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    private boolean isTokenExpired(PasswordResetTokenEntity token) {
        final Calendar cal = Calendar.getInstance();
        return token.getExpiryDate().before(cal.getTime());
    }

    // Method to validate the token
    public boolean validatePasswordResetToken(String token) {
        Optional<PasswordResetTokenEntity> passToken = passwordResetTokenRepository.findByToken(token);
        return passToken.isPresent() && !isTokenExpired(passToken.get());
    }

    public void changeUserPassword(UserEntity user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

}
