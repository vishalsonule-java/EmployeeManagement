package com.mb.EmpMangApp.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	
	@Value(value = "${app.key}")
	private String key;
	
	public Boolean isTokenValidate(String token,String subject) {
		String username = getClaims(token).getSubject();
		return (username.equals(subject)&& !isTokenExpried(token));
	}
	
	public boolean isTokenExpried(String token){
		Date expiration = getClaims(token).getExpiration();
		return expiration.before(new Date(System.currentTimeMillis()));
	}
	
	public String getSubject(String token) {
		return getClaims(token).getSubject();
	}
	
	public Claims getClaims(String token) {
		return Jwts.parser()
		.setSigningKey(Base64.getEncoder().encode(key.getBytes()))
		.parseClaimsJws(token)
		.getBody();
	}
	
	public String generateToken(String subject) {
		return Jwts.builder()
		.setSubject(subject)
		.setIssuer("MbBowser")
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))
		.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes()))
		.compact();
	}
	
	
}
