package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.auth.AuthService;
import com.erenberik.flightsearchapi.dto.LoginReqDTO;
import com.erenberik.flightsearchapi.dto.RestResponse;
import com.erenberik.flightsearchapi.dto.SignUpReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<RestResponse<String>> login(@RequestBody LoginReqDTO loginReqDTO) {

        String token = authService.login(loginReqDTO);

        return ResponseEntity.ok(RestResponse.of(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<RestResponse<Void>> signUp(@RequestBody SignUpReqDTO signUpReqDTO) {

        authService.signUp(signUpReqDTO);

        return ResponseEntity.ok(RestResponse.empty());
    }
}
