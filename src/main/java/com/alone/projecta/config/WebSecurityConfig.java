package com.alone.projecta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.alone.projecta.services.CustomUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			
			// open pages
			.antMatchers("/").permitAll()
		
			// restricted pages
			.antMatchers("/list-servers").hasAnyRole("USER", "ADM")
			.antMatchers("/client-panel").hasAnyRole("USER", "ADM")
			
			// temporary login page
			.anyRequest().authenticated()
			.and().formLogin().permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			
			// default page after successful authentication
			.and().formLogin().defaultSuccessUrl("/dashboard", true)
			
			// default page access failure
			.and().exceptionHandling().accessDeniedPage("/disabled");
			
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}