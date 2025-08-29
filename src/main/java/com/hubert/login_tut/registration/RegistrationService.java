package com.hubert.login_tut.registration;

import com.hubert.login_tut.appuser.AppUser;
import com.hubert.login_tut.appuser.AppUserRepository;
import com.hubert.login_tut.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String register(RegistrationRequest request) {
        // Check if user already exists
        if (appUserRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        // Create new user
        AppUser appUser = new AppUser(
                request.getUsername(),
                request.getEmail(),
                bCryptPasswordEncoder.encode(request.getPassword()),
                AppUserRole.USER,
                false, // not locked
                true   // enabled
        );

        // Save user
        appUserRepository.save(appUser);

        return "User registered successfully";
    }
}