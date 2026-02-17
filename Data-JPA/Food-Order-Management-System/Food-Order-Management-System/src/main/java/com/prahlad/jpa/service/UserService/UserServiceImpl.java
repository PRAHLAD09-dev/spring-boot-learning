package com.prahlad.jpa.service.UserService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prahlad.jpa.dto.OrderItemResponseDto;
import com.prahlad.jpa.dto.OrderResponseDto;
import com.prahlad.jpa.dto.UserRequestDto;
import com.prahlad.jpa.dto.UserResponseDto;
import com.prahlad.jpa.entity.User;
import com.prahlad.jpa.exception.ResourceNotFoundException;
import com.prahlad.jpa.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{

    private final UserRepository userRepository;
    

    public UserServiceImpl( UserRepository userRepository)
    {
        this.userRepository = userRepository;
       
    }

    // ================= USER CRUD =================

    @Override
    public UserResponseDto createUser(UserRequestDto dto) 
    {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());

        return mapToUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponseDto getUserById(Long userId)
    {
        return mapToUserResponse(
                getUserEntity(userId)
        );
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto dto)
    {
        User user = getUserEntity(userId);
        user.setName(dto.name());
        user.setEmail(dto.email());

        return mapToUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long userId)
    {
        userRepository.delete(getUserEntity(userId));
    }

    
    // ================= HELPERS =================

    private User getUserEntity(Long userId) 
    {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId ));
    }
    
    private UserResponseDto mapToUserResponse(User user)
    {
        List<OrderResponseDto> orders =
                user.getOrders()
                    .stream()
                    .map(order -> {

                        List<OrderItemResponseDto> orderItems =
                                order.getItems()
                                     .stream()
                                     .map(item -> new OrderItemResponseDto(
                                             item.getId(),
                                             item.getProductName(),
                                             item.getQuantity(),
                                             item.getprice()
                                     ))
                                     .toList();

                        return new OrderResponseDto(
                                order.getId(),
                                order.getStatus(),
                                user.getId(),
                                orderItems
                        );
                    })
                    .toList();

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                orders
        );
    }
    
}