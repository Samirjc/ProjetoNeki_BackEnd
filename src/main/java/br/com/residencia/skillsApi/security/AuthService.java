package br.com.residencia.skillsApi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.residencia.skillsApi.models.User;
import br.com.residencia.skillsApi.services.UserService;

@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
	UserService userService;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByLogin(username);
		return new UserSS(user);
	}
}
