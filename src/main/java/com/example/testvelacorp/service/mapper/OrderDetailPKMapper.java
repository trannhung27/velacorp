package com.example.testvelacorp.service.mapper;

import com.example.testvelacorp.dto.OrderDetailPKDto;
import com.example.testvelacorp.modal.OrderDetailPK;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface OrderDetailPKMapper extends EntityMapper<OrderDetailPKDto, OrderDetailPK> {
}
