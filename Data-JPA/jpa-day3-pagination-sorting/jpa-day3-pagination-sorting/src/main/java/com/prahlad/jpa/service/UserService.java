package com.prahlad.jpa.service;

import org.springframework.stereotype.Service;
import com.prahlad.jpa.repository.UserRepository;

import com.prahlad.jpa.dto.UserResponseDto;
import com.prahlad.jpa.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
public class UserService 
{

    private final UserRepository repo;
    
    public UserService(UserRepository repo) 
    {
	
		this.repo = repo;
	}

	public Page<UserResponseDto> getUsers(int page, int size, String sortBy) 
    {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending()
        );

        Page<User> usersPage = repo.findAll(pageable);

        return usersPage.map(user ->
                new UserResponseDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                )
        );
    }
}