package com.course.application;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("foo")
		.password(getPasswordEncoder().encode("foopass"))
		.roles("USER");
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
			}
		};
	}
	
}
