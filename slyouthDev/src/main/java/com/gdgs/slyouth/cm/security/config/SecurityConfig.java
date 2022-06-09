package com.gdgs.slyouth.cm.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gdgs.slyouth.cm.handler.CmLoginFailureHandler;
import com.gdgs.slyouth.cm.handler.CmLoginSuccessHandler;
import com.gdgs.slyouth.cm.security.provider.CmAuthenticationProvider;

/**
 * @title	: Spring Security 설정 클래스	  
 * @author	: mosekim
 * @create	: 2021.04.13
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CmLoginSuccessHandler cmLoginSuccessHandler;
	
	@Autowired
	CmLoginFailureHandler cmLoginFailureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new CmAuthenticationProvider();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			/** Intercept URL */
			.authorizeRequests()
			.antMatchers("/", "/mi/**", "/cm/login", "/cm/join").permitAll()
			.antMatchers("/cm/**").permitAll()
			.antMatchers("/ws/**").permitAll()
			.antMatchers("/sd/**").permitAll()
			.antMatchers("/ng/**").permitAll()
			.antMatchers("/um/**").permitAll()
			.antMatchers("/nt/**").permitAll()
			.antMatchers("/wk/**").permitAll()
			.antMatchers("/nm/**").permitAll()
			.antMatchers("/yg/**").permitAll()
			.antMatchers("/ps/**").permitAll()
			.antMatchers("/nf/**").permitAll()
			.anyRequest().authenticated()
			.and()
			
			/** Login */
			.formLogin()
			.loginPage("/cm/login")
			.usernameParameter("usrId")
			.passwordParameter("usrPw")
			.loginProcessingUrl("/loginProc")
			.successHandler(cmLoginSuccessHandler)
			.failureHandler(cmLoginFailureHandler)
			.permitAll()
			.and()
			
			/** Logout */
			.logout()
			.invalidateHttpSession(true)
			.and()
			//.exceptionHandling()
			//.accessDeniedHandler()
		
			/** Header */
			.headers()
			.cacheControl().disable()
			.frameOptions().sameOrigin();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**")
					  .antMatchers("/js/**")
					  .antMatchers("/images/**");
	}
}
