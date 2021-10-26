package com.alone.projecta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alone.projecta.domain.Account;
import com.alone.projecta.repository.AccountRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	private final AccountRepository accountRepositosry;
	
	@Autowired
	public CustomUserDetailsService(AccountRepository accountRepository) {
		this.accountRepositosry = accountRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account acc = Optional.ofNullable(accountRepositosry.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("Account Not Found!"));
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new org.springframework.security.core.userdetails.User(acc.getUsername(), acc.getPassword(), authorityListUser);
	}
}
