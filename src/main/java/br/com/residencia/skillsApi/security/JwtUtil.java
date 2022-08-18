package br.com.residencia.skillsApi.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private static String secret = "serratec";
	private Long expiration = (long) 3600000;
	
	
	public String generateToken(String username, Authentication authResult) {
		
		return Jwts.builder()
				.setSubject(username)
				.claim("roles", "testando")
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey(secret.getBytes())
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			
			
			if(user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, null);
			}
		}
		
		return null;
		//Adicionar exception
	}
}
