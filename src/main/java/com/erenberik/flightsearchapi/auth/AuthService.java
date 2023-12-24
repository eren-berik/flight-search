package com.erenberik.flightsearchapi.auth;

import com.erenberik.flightsearchapi.dto.LoginReqDTO;
import com.erenberik.flightsearchapi.dto.SignUpReqDTO;
import com.erenberik.flightsearchapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public String login(LoginReqDTO loginReqDTO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginReqDTO.getUsername(), loginReqDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateJwtToken(authentication);
    }

    public void signUp(SignUpReqDTO signUpReqDTO) {
        userService.signUpUser(signUpReqDTO);
    }

    private JwtUserDetails getCurrentJwtUserDetails() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails) {
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }
        return jwtUserDetails;
    }
}
