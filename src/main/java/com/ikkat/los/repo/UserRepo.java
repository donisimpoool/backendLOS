//package com.ikkat.los.repo;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.ikkat.los.entity.UserEntity;
//
//@Repository("UserRepo")
//public interface UserRepo extends JpaRepository<UserEntity, Long>{
//	@Query(value =" select * from \"user\" "
//			+ " where userid = :userid limit 1 ",nativeQuery = true)
//	public UserEntity getLogin(@Param("userid") String userid);
//
//
//	@Query(value =" select * from \"user\" "
//			+ " where usertype = :usertype ",nativeQuery = true)
//	public List<UserEntity> getListByUserType(@Param("usertype") String usertype);
//}
