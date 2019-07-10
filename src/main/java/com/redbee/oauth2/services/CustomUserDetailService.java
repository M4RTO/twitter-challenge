package com.redbee.oauth2.services;

import com.redbee.oauth2.entity.CustomUserDetails;
import com.redbee.oauth2.entity.User;
import com.redbee.oauth2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = usersRepository.findByName(username).orElseThrow(EntityNotFoundException::new);
        Optional<User> user = usersRepository.findByName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User doesnt Exist"));

        // return Optional.of(user).map(CustomUserDetails::new).get();
        return user.map(CustomUserDetails::new).get();

    }
}
