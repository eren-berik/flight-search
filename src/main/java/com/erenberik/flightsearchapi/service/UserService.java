package com.erenberik.flightsearchapi.service;

import com.erenberik.flightsearchapi.dto.LoginReqDTO;
import com.erenberik.flightsearchapi.dto.SignUpReqDTO;
import com.erenberik.flightsearchapi.model.User;

public interface UserService {
    User findByUsername(String username);

    void signUpUser(SignUpReqDTO signUpReqDTO);
    void login(LoginReqDTO loginReqDTO);
}
