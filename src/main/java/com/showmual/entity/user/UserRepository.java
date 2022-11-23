package com.showmual.entity.user;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;



public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	@Query(value = "select id from users_tbl where username = :username", nativeQuery = true)
	String findIdByUsername(String username);
	
	//@Query(value = "select count(userId) from users_tbl where userId = :userId", nativeQuery = true)
	Long countByUsername(String username);
	
	//@Query(value = "select count(nickname) from users_tbl where nickname = :nickname", nativeQuery = true)
	Long countByNickname(String nickname);
	
	// Email로 ID 찾기
	@Query(value = "select username from users_tbl where email = :email", nativeQuery = true)
	String findUsernameByEmail(String email);
	
	// 해당 username(ID) 비밀번호 변경하기
	@Query(value = "update users_tbl set password = :password where id = :id", nativeQuery = true)
	@Transactional  // update, delete 쿼리 사용할땐 Transactional, Modifying 어노테이션 필요하다.
	@Modifying
	void updatePasswordById(String password, Long id);
}
