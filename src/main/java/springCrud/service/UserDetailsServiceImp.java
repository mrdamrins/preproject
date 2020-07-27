package springCrud.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

  private final UserService userService;

  public UserDetailsServiceImp(UserService userService) {
    this.userService = userService;
  }

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserDetails userDetails = userService.getUserByUsername(username);

    if (userDetails == null) {
      throw new UsernameNotFoundException("username " + username + " not found");
    }

    return userDetails;
  }
}

