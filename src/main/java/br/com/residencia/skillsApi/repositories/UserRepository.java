package br.com.residencia.skillsApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.skillsApi.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByLogin(String login);
}
