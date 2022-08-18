package br.com.residencia.skillsApi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.residencia.skillsApi.exceptions.ExistingUserException;
import br.com.residencia.skillsApi.exceptions.NonExistingUserException;
import br.com.residencia.skillsApi.models.User;
import br.com.residencia.skillsApi.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public void create(User user) throws ExistingUserException {
		Optional<User> optional = userRepository.findByLogin(user.getLogin());
		
		if(optional.isPresent()) {
			throw new ExistingUserException();
		}
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public User findById(Integer id) throws NonExistingUserException {
		Optional<User> optional = userRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new NonExistingUserException();
		}
		
		return optional.get();
	}
	
	public User findUserByLogin(String login) {
		Optional<User> optional = userRepository.findByLogin(login);
		
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		return optional.get();
	}
}
