package br.com.residencia.skillsApi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.skillsApi.exceptions.ExistingUserException;
import br.com.residencia.skillsApi.models.User;
import br.com.residencia.skillsApi.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public void create(User user) throws ExistingUserException {
		Optional<User> optional = userRepository.findByLogin(user.getLogin());
		
		if(optional.isPresent()) {
			throw new ExistingUserException();
		}
		
		userRepository.save(user);
	}
}
