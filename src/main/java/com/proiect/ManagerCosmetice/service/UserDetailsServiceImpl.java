package com.proiect.ManagerCosmetice.service;

import com.proiect.ManagerCosmetice.entity.User;
import com.proiect.ManagerCosmetice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.proiect.ManagerCosmetice.security.CustomUserDetails;

/**
 * face legătura între formularul de login și baza de date;
 * el verifică dacă username-ul introdus există
 * și returnează datele necesare pentru validarea parolei.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUtilizator(username)
                .orElseThrow(() -> new UsernameNotFoundException("User negăsit"));

        return new com.proiect.ManagerCosmetice.security.CustomUserDetails(user);
    }
}