package com.toy.traveldiary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;



@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
								.antMatchers("/").permitAll()
								.anyRequest().authenticated()
								.and()
			.formLogin()
						.loginPage("/member/signin")
						.defaultSuccessUrl("/")
						.usernameParameter("email")
						.permitAll()
						.and()
			.logout()
						.logoutUrl("/member/signout")
						.logoutSuccessUrl("/")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
						.permitAll()
			;
		
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/icons/**", "/images/**");
	}
	
	

}
