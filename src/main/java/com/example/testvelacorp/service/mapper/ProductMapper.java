package com.example.testvelacorp.service.mapper;

import com.example.testvelacorp.dto.ProductDto;
import com.example.testvelacorp.modal.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDto, Product>{
}
