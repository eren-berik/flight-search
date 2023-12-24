package com.erenberik.flightsearchapi.auth;

import com.erenberik.flightsearchapi.model.User;
import com.erenberik.flightsearchapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class JwtUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User usrUser = userService.findByUsername(username);

        return JwtUserDetails.create(usrUser);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

