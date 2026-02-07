package com.prahlad.rest.service;

import com.prahlad.rest.dto.UserRequestDto;
import com.prahlad.rest.dto.UserResponseDto;
import com.prahlad.rest.exception.UserNotFoundException;
import com.prahlad.rest.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {

    private final Map<Integer, User> userStore = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public UserResponseDto createUser(UserRequestDto dto) {

        int id = idCounter.getAndIncrement();

        User user = new User(id, dto.getName(), dto.getEmail());
        userStore.put(id, user);

        return new UserResponseDto(id, user.getName(), user.getEmail());
    }

    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> list = new ArrayList<>();

        for (User user : userStore.values()) {
            list.add(new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
            ));
        }
        return list;
    }

    public UserResponseDto getUserById(int id) {
        User user = userStore.get(id);

        if (user == null) {
            throw new UserNotFoundException(id);
        }

        return new UserResponseDto(
            user.getId(),
            user.getName(),
            user.getEmail()
        );
    }

    public void deleteUser(int id) {
        if (!userStore.containsKey(id)) {
            throw new UserNotFoundException(id);
        }
        userStore.remove(id);
    }
}