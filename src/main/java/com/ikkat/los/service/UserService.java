package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.ikkat.los.entity.UserEntity;

public interface UserService {
	List<UserEntity> findAll();
	Optional<UserEntity> findById(long id);
	UserEntity update(long id, UserEntity cs);

	UserEntity create(UserEntity cs);
	
	void delete(long id);
	
	UserEntity login(String userid);
	
	List<UserEntity> getListByUserType(String usertype);
}
