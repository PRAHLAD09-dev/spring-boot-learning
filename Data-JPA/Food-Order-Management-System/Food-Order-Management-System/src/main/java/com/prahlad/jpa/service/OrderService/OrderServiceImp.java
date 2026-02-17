package com.prahlad.jpa.service.OrderService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prahlad.jpa.dto.OrderItemRequestDto;
import com.prahlad.jpa.dto.OrderItemResponseDto;
import com.prahlad.jpa.dto.OrderRequestDto;
import com.prahlad.jpa.dto.OrderResponseDto;
import com.prahlad.jpa.entity.Order;
import com.prahlad.jpa.entity.OrderItem;
import com.prahlad.jpa.entity.Product;
import com.prahlad.jpa.entity.User;
import com.prahlad.jpa.exception.ResourceNotFoundException;
import com.prahlad.jpa.repository.OrderItemRepository;
import com.prahlad.jpa.repository.OrderRepository;
import com.prahlad.jpa.repository.ProductRepository;
import com.prahlad.jpa.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImp implements OrderService 
{
	    private final UserRepository userRepository;
	    private final OrderRepository orderRepository;
	    private final OrderItemRepository orderItemRepository;
	    private final ProductRepository productRepository;

	    public OrderServiceImp(
	            UserRepository userRepository,
	            OrderRepository orderRepository,
	            OrderItemRepository orderItemRepository,
	            ProductRepository productRepository) 
	    {

	        this.userRepository = userRepository;
	        this.orderRepository = orderRepository;
	        this.orderItemRepository = orderItemRepository;
	        this.productRepository = productRepository;
	    }
	    
	 // ================= USER → ORDER =================

	    @Override
	    public OrderResponseDto placeOrder(Long userId, OrderRequestDto dto) 
	    {

	        User user = getUserEntity(userId);

	        Order order = new Order();
	        order.setUser(user);
	        order.setStatus("CREATED");

	        Order savedOrder = orderRepository.save(order);
	     
	        for (OrderItemRequestDto itemDto : dto.items()) 
	        {

	            Product product = productRepository
	                    .findByName(itemDto.productName())
	                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

	            double finalPrice = product.getPrice() * itemDto.quantity();

	            OrderItem item = new OrderItem();
	            item.setOrder(savedOrder);
	            item.setProductName(product.getName());
	            item.setQuantity(itemDto.quantity());
	            item.setprice(finalPrice);

	            orderItemRepository.save(item);

	            savedOrder.getItems().add(item);
	        }
	        
	        Order orderWithItems =
	                orderRepository.findWithItems(savedOrder.getId());

	        return mapToOrderResponse(orderWithItems);
	    }
	

    @Override
    public List<OrderResponseDto> getUserOrders(Long userId) 
    {

        return orderRepository.findById(userId)
                .stream()
                .map(this::mapToOrderResponse)
                .toList();
    }

    

    // ================= HELPERS =================
    
    @Override
    public OrderResponseDto getUserOrderById(Long userId, Long orderId)
    {

        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found for user")
                );

        return mapToOrderResponse(order);
    }
 
     private User getUserEntity(Long userId) 
    {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId ));
    }
    
    private OrderResponseDto mapToOrderResponse(Order order) 
    {
    	Long userId = null;
    	if(order.getUser() != null)
    	{
    		userId = order.getUser().getId();
    	}
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
    	            userId,
    	            orderItems
    	    );
    	}
}
