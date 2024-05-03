package com.example.testvelacorp.service;

import com.example.testvelacorp.constant.ApiResponseCode;
import com.example.testvelacorp.dto.ProductDto;
import com.example.testvelacorp.dto.response.CommonResponseDto;
import com.example.testvelacorp.exception.HandleException;
import com.example.testvelacorp.modal.Product;
import com.example.testvelacorp.repository.ProductRepository;
import com.example.testvelacorp.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public CommonResponseDto saveProduct(ProductDto productDto){
        productRepository.save(productMapper.toEntity(productDto));
        return CommonResponseDto.builder().response("SUCCESS").status("200").build();
    }

    public ProductDto getProductDetail(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()) {
            throw new HandleException(ApiResponseCode.ENTITY_NOT_FOUND);
        }
        return productMapper.toDto(product.get());
    }

    public ProductDto updateProduct(ProductDto productDto){
        Optional<Product> product = productRepository.findById(productDto.getId());
        if(!product.isPresent()) {
            throw new HandleException(ApiResponseCode.ENTITY_NOT_FOUND);
        }
        productMapper.partialUpdate(product.get(), productDto);
        productRepository.save(product.get());
        return productMapper.toDto(product.get());
    }

    public CommonResponseDto deleteProduct(Long id){
        productRepository.deleteById(id);
        return CommonResponseDto.builder().response("SUCCESS").status("200").build();
    }

    public Page<ProductDto> getAllProduct(String name, String description, Pageable pageable){
        return productRepository.findAllProduct(name, description, pageable).map(productMapper::toDto);
    }

}
