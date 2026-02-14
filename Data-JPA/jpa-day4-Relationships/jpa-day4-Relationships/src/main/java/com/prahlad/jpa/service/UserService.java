package com.prahlad.jpa.service;

import com.prahlad.jpa.repository.OrderRepository;
import com.prahlad.jpa.repository.UserRepository;

import jakarta.transaction.Transactional;

import com.prahlad.jpa.entity.Order;
import com.prahlad.jpa.entity.User;
import com.prahlad.jpa.exception.BadRequestException;
import com.prahlad.jpa.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService 
{

    private final UserRepository userRepository;
    private final OrderRepository  orderRepository;
    

    public UserService(UserRepository userRepository ,OrderRepository  orderRepository) 
    {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }
    
 
    public User createUser(User user) 
    {
        if (user.getOrders() != null) 
        {
            for (Order order : user.getOrders()) 
            {
                order.setUser(user);   
            }
        }

        return userRepository.save(user);
    }

    public User addOrder(Long userId, Order order) 
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id " + userId));

        user.addOrder(order);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() 
    {
        return userRepository.findAll();
    }

    public User getById(Long userId) 
    {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }
    
    @Transactional
    public User removeOrder(Long userId, Long orderId) 
    {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id " + userId));

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found with id " + orderId));

        if (order.getUser() == null ||
            !order.getUser().getId().equals(userId)) 
        {

            throw new BadRequestException("Order does not belong to this user");
        }

        user.removeOrder(order);
        return user;
    }
}