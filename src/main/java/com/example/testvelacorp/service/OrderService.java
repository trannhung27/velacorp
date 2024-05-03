package com.example.testvelacorp.service;

import com.example.testvelacorp.constant.ApiResponseCode;
import com.example.testvelacorp.dto.OrderDetailDto;
import com.example.testvelacorp.dto.OrderDto;
import com.example.testvelacorp.dto.response.CommonResponseDto;
import com.example.testvelacorp.exception.HandleException;
import com.example.testvelacorp.modal.Order;
import com.example.testvelacorp.repository.OrderDetailRepository;
import com.example.testvelacorp.repository.OrderRepository;
import com.example.testvelacorp.service.mapper.OrderDetailMapper;
import com.example.testvelacorp.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final OrderDetailRepository orderDetailRepository;

    private final OrderDetailMapper orderDetailMapper;

    public CommonResponseDto saveOrder(OrderDto orderDto){
        orderRepository.save(orderMapper.toEntity(orderDto));
        orderDetailRepository.saveAll(orderDetailMapper.toEntity(orderDto.getOrderDetails()));
        return CommonResponseDto.builder().response("SUCCESS").status("200").build();
    }

    public OrderDto getOrderDetail(Long id){
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()) {
            throw new HandleException(ApiResponseCode.ENTITY_NOT_FOUND);
        }
        OrderDto orderDto = orderMapper.toDto(order.get());
        List<OrderDetailDto> orderDetails = orderDetailRepository.findByIdIdOrder(1L).stream().map(orderDetailMapper::toDto).collect(Collectors.toList());
        orderDto.setOrderDetails(orderDetails);
        return orderDto;
    }

    public OrderDto updateOrder(OrderDto orderDto){
        Optional<Order> order = orderRepository.findById(orderDto.getId());
        if(!order.isPresent()) {
            throw new HandleException(ApiResponseCode.ENTITY_NOT_FOUND);
        }
        orderMapper.partialUpdate(order.get(), orderDto);
        orderRepository.save(order.get());
        return orderMapper.toDto(order.get());
    }

    public Page<OrderDto> getAllOrder(String customerName, Long idOrder, Pageable pageable){
        return orderRepository.findAllOrder(customerName, idOrder, pageable).map(orderMapper::toDto);
    }
}
