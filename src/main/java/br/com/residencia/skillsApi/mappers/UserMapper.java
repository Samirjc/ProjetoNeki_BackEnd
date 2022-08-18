package br.com.residencia.skillsApi.mappers;

import org.springframework.stereotype.Component;

import br.com.residencia.skillsApi.dtos.UserDTO;
import br.com.residencia.skillsApi.models.User;

@Component
public class UserMapper {
	
	public User UserDtoToUser(UserDTO dto) {
		User user = new User();
		
		user.setLogin(dto.getLogin());
		user.setPassword(dto.getPassword());
		
		return user;
	}
}
