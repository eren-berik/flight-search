package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.LoginReqDTO;
import com.erenberik.flightsearchapi.dto.SignUpReqDTO;
import com.erenberik.flightsearchapi.exception.AlreadyExistsException;
import com.erenberik.flightsearchapi.exception.NotFoundException;
import com.erenberik.flightsearchapi.exception.errors.AirportErrors;
import com.erenberik.flightsearchapi.exception.errors.UserErrors;
import com.erenberik.flightsearchapi.model.User;
import com.erenberik.flightsearchapi.repository.UserRepository;
import com.erenberik.flightsearchapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(UserErrors.USER_NOT_FOUND));
    }

    @Override
    public void signUpUser(SignUpReqDTO signUpReqDTO) {
        User user = new User();
        user.setUsername(signUpReqDTO.getUsername());
        user.setPassword(signUpReqDTO.getPassword()); //todo:need to encode password
        user.setEmail(signUpReqDTO.getEmail());

        userRepository.save(user);
    }

    public void login(LoginReqDTO loginReqDTO) {

        String username = loginReqDTO.getUsername();
        String password = loginReqDTO.getPassword();

        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(UserErrors.USER_NOT_FOUND)));

        if (user.get().getPassword().equals(password)) {

        } else {
            throw new NotFoundException(AirportErrors.AIRPORT_NOT_FOUND);
        }
    }
}
