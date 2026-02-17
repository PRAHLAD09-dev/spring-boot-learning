package com.prahlad.jpa.service.Admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prahlad.jpa.dto.*;
import com.prahlad.jpa.entity.*;
import com.prahlad.jpa.exception.ResourceNotFoundException;
import com.prahlad.jpa.repository.*;

@Service
@Transactional
public class AdminServiceImpl implements AdminService 
{

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public AdminServiceImpl(
            UserRepository userRepository,
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository) 
    {

        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    // ================= USERS =================

    @Override
    public List<AdminUserResponseDto> getAllUsers() 
    {
        return userRepository.findAll()
                .stream()
                .map(this::mapToAdminUser)
                .toList();
    }

    @Override
    public AdminUserResponseDto getUserById(Long userId) 
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id" + userId));

        return mapToAdminUser(user);
    }

    @Override
    public void deleteUser(Long userId) 
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id" + userId));

        userRepository.delete(user);
    }

    @Override
    public List<AdminUserResponseDto> searchUsers(String keyword)
    {
        return userRepository.searchUser(keyword)
                .stream()
                .map(this::mapToAdminUser)
                .toList();
    }

    // ================= ORDERS =================

    @Override
    public PageResponseDto<AdminOrderResponseDto> getAllOrders(Pageable pageable)
    {

        Page<Order> page = orderRepository.findAll(pageable);
      
        List<AdminOrderResponseDto> content =
                page.getContent()
                    .stream()
                    .map(this::mapToAdminOrder)
                    .toList();

        return new PageResponseDto<>(
        		content,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public AdminOrderResponseDto getOrderById(Long orderId) 
    {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found"));

        return mapToAdminOrder(order);
    }

    @Override
    public PageResponseDto<AdminOrderResponseDto> getOrdersByStatus(
            String status, Pageable pageable) 
    {

        Page<Order> page =
                orderRepository.findByStatus(status, pageable);

        List<AdminOrderResponseDto> content =
                page.getContent()
                    .stream()
                    .map(this::mapToAdminOrder)
                    .toList();

        return new PageResponseDto<>(
                content,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public AdminOrderResponseDto updateOrderStatus(
            Long orderId, OrderStatusUpdateDto dto) 
    {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found"));

        order.setStatus(dto.status());
        return mapToAdminOrder(orderRepository.save(order));
    }

    @Override
    public void deleteOrder(Long orderId)
    {
    	Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found"));

        orderRepository.delete(order);
    }

    // ================= ORDER ITEMS =================

    @Override
    public List<AdminOrderItemResponseDto> getItemsByOrderId(Long orderId)
    {

        return orderItemRepository.fetchItemsByOrder(orderId)
                .stream()
                .map(this::mapToAdminOrderItem)
                .toList();
    }

    @Override
    public List<AdminOrderItemResponseDto> getItemsWithPriceGreaterThan(
    		double price) {

        return orderItemRepository.findByPriceGreaterThan(price)
                .stream()
                .map(this::mapToAdminOrderItem)
                .toList();
    }

    // ================= MAPPERS =================

    private AdminUserResponseDto mapToAdminUser(User user)
    {

        return new AdminUserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
               
        );
    }

    private AdminOrderResponseDto mapToAdminOrder(Order order) 
    {

        return new AdminOrderResponseDto(
                order.getId(),
                order.getStatus(),
                order.getUser().getId()
                
        );
    }

    private AdminOrderItemResponseDto mapToAdminOrderItem(OrderItem item) 
    {

        return new AdminOrderItemResponseDto(
                item.getId(),
                item.getProductName(),
                item.getQuantity(),
                item.getprice()
        );
    }

	
}