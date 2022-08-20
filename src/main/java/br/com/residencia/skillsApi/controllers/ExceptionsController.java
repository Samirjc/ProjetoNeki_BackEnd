package br.com.residencia.skillsApi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.residencia.skillsApi.exceptions.ExistingSkillException;
import br.com.residencia.skillsApi.exceptions.ExistingUserException;
import br.com.residencia.skillsApi.exceptions.ExistingUserSkillException;
import br.com.residencia.skillsApi.exceptions.NonExistingSkillException;
import br.com.residencia.skillsApi.exceptions.NonExistingUserException;
import br.com.residencia.skillsApi.exceptions.NonExistingUserSkillException;

@RestControllerAdvice
public class ExceptionsController {
	
	@ExceptionHandler(ExistingSkillException.class)
	public ResponseEntity<String> handleExistingSkill() {
		String msg = "Skill já existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(ExistingUserException.class)
	public ResponseEntity<String> handleExistingUser() {
		String msg = "Usuário já existe";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(ExistingUserSkillException.class)
	public ResponseEntity<String> handleExistingUserSkill() {
		String msg = "Skill já inclusa";
		return ResponseEntity.badRequest().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(NonExistingSkillException.class)
	public ResponseEntity<String> handleNonExistingSkill() {
		String msg = "Skill não existe";
		return ResponseEntity.notFound().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(NonExistingUserException.class)
	public ResponseEntity<String> handleNonExistingUser() {
		String msg = "Usuário não existe";
		return ResponseEntity.notFound().header("errorMsg", msg).build();
	}
	
	@ExceptionHandler(NonExistingUserSkillException.class)
	public ResponseEntity<String> handleNonExistingUserSkill() {
		String msg = "Skill não inclusa";
		return ResponseEntity.notFound().header("errorMsg", msg).build();
	}
}
