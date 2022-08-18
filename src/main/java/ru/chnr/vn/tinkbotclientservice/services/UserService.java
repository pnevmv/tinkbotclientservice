package ru.chnr.vn.tinkbotclientservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.chnr.vn.tinkbotclientservice.repos.UserRepo;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(repo.findByUserName(username) == null)
            throw new UsernameNotFoundException("user not found");

        return repo.findByUserName(username);
    }
}
