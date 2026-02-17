package com.prahlad.jpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prahlad.jpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{

    boolean existsByEmail(String email);

    List<User> findByNameContainingIgnoreCase(String name);
 
    
    @Query("""
    	       select u from User u 
    	       where lower(u.name) like lower(concat('%', :keyword, '%'))
    	          or lower(u.email) like lower(concat('%', :keyword, '%'))
    	       """)
    	List<User> searchUser(String keyword);
}