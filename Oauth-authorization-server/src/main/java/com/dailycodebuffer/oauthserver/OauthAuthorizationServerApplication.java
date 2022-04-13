package com.dailycodebuffer.oauthserver;

import com.dailycodebuffer.oauthserver.entity.User;
import com.dailycodebuffer.oauthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OauthAuthorizationServerApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(OauthAuthorizationServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setFirstName("abc");
		user.setLastName("xyz");
		user.setEmail("a@b.com");
		user.setPassword(passwordEncoder.encode("abc"));
		user.setRole("USER");
		userRepository.save(user);
	}
}
