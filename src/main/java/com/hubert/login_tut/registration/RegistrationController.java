package com.hubert.login_tut.registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = "/registration", consumes = "application/json")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request){
        String result = registrationService.register(request);
        return ResponseEntity.ok(result);
    }
}