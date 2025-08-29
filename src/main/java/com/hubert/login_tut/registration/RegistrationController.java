package com.hubert.login_tut.registration;

import com.hubert.login_tut.appuser.AppUser;
import com.hubert.login_tut.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping(value = "/registration", consumes = "application/json")
    public AppUser createUser(@RequestBody AppUser appUser){
        return  appUserRepository.save(appUser);
    }
}