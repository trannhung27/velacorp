package com.example.testvelacorp.service.mapper;

import com.example.testvelacorp.dto.OrderDto;
import com.example.testvelacorp.modal.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface OrderMapper extends EntityMapper<OrderDto, Order>{


}
