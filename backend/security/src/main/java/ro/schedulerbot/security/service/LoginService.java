package ro.schedulerbot.security.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ro.schedulerbot.security.model.JwtUser;

public interface LoginService extends UserDetailsService {

  JwtUser loadUserByUsername(String username) throws UsernameNotFoundException;
}
