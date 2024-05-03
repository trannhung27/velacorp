package com.example.testvelacorp.controlller;

import com.example.testvelacorp.dto.ProductDto;
import com.example.testvelacorp.dto.response.CommonResponseDto;
import com.example.testvelacorp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<CommonResponseDto> saveProduct(@Valid @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductDetail(id));
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<CommonResponseDto> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/products")
    public ResponseEntity<Page<ProductDto>> getAllProduct(@RequestParam(required = false) String name, @RequestParam(required = false) String description ,
                                                          Pageable pageable){
        return ResponseEntity.ok(productService.getAllProduct(name, description, pageable));
    }

}
