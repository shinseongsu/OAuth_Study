package com.example.oAuth.service;

import com.example.oAuth.repository.UserRepository;
import com.example.oAuth.user.ClientUser;
import com.example.oAuth.user.ClientUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ClientUser> optionalUser =
                users.findByUsername(username);
        if(!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("invalid username or password");
        }
        return new ClientUserDetails(optionalUser.get());
    }
}
