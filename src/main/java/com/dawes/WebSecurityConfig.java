package com.dawes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dawes.servicios.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder;
	}
	
	// Método en el que se lee la información de la base de datos
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		// Buscamos el usuario a traves del servicio y se encripta la password introducida en el login
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
			
		http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll()
		.antMatchers("/registrado/**").access("hasRole('USER')")
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().formLogin()
			.loginProcessingUrl("/j_spring_security_check")
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.usernameParameter("username")
			.passwordParameter("password");
		
		http.formLogin().defaultSuccessUrl("/principal", true);

	}
}
