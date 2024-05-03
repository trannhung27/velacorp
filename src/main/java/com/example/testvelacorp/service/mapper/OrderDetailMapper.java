package com.example.testvelacorp.service.mapper;

import com.example.testvelacorp.dto.OrderDetailDto;
import com.example.testvelacorp.modal.OrderDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { OrderDetailPKMapper.class})
public interface OrderDetailMapper extends EntityMapper<OrderDetailDto, OrderDetails>{
}
