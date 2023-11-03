package com.ikkat.los.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.UserEntity;
import com.ikkat.los.repo.UserRepo;
import com.ikkat.los.service.UserService;

@Service(value = "userService")
public class UserImpl implements UserDetailsService,UserService {
	@Autowired
	private UserRepo repository;
	//(value = "userService")
	@Override
	public Optional<UserEntity> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public UserEntity update(long id, UserEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public UserEntity create(UserEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public UserEntity login(String userid) {
		// TODO Auto-generated method stub
		return repository.getLogin(userid);
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<UserEntity> getListByUserType(String usertype) {
		// TODO Auto-generated method stub
		return repository.getListByUserType(usertype);
	}
	
	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	public List findAll1() {
		List list = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("username : "+username);
		UserEntity user = repository.getLogin(username);
		System.out.println("user : "+user);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserid(), user.getPassword(), getAuthority());
	}

}
