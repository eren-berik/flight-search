package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.dto.RestResponse;
import com.erenberik.flightsearchapi.dto.SignUpReqDTO;
import com.erenberik.flightsearchapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<RestResponse<Void>> signUpUser(@RequestBody SignUpReqDTO signUpReqDTO) {
        userService.signUpUser(signUpReqDTO);

        return ResponseEntity.ok(RestResponse.empty());
    }
}
