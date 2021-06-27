package com.example.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

//import com.example.repository.mysql.IMySQLPlayerRepository;
import com.example.repository.mongo.IMongoDBPlayerRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.example.domain.Player;

@Service
public class PlayerService {

	@Autowired
	//IMySQLPlayerRepository iPlayerRepository;
	IMongoDBPlayerRepository iPlayerRepository;
	
	public List<Player> read() {
		return iPlayerRepository.findAll();
	}

	public Optional<Player> readById(String id) {
		return iPlayerRepository.findById(id);
	}
	
	public Player create(Player player) {
		player.setDate(LocalDate.now());
		player.setToken(this.getJWTToken(player.getName()));
		
		return iPlayerRepository.save(player);
	}

	public void update(Player player) {
		iPlayerRepository.save(player);
	}
	
	private String getJWTToken(String name) {
		String secretKey = "mySecretKey";
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
			.commaSeparatedStringToAuthorityList("ROLE_USER");
				
		String token = Jwts.builder()
			.setId("softtekJWT")
			.setSubject(name)
			.claim(
					"authorities",
					grantedAuthorities.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList())
				)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + 600000))
			.signWith(
					SignatureAlgorithm.HS512,
					secretKey.getBytes()
				)
			.compact();
		
		return "Bearer " + token;
	}
	
}
