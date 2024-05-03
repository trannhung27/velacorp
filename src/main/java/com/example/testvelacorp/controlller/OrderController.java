package com.example.testvelacorp.controlller;

import com.example.testvelacorp.dto.OrderDto;
import com.example.testvelacorp.dto.CommonResponseDto;
import com.example.testvelacorp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<CommonResponseDto> saveOrder(@Valid @RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.saveOrder(orderDto));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getOrderDetail(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getOrderDetail(id));
    }

    @PutMapping("/order")
    public ResponseEntity<OrderDto> updateOrder(@Valid @RequestBody OrderDto requestDto){
        return ResponseEntity.ok(orderService.updateOrder(requestDto));
    }

    @GetMapping("/orders")
    public ResponseEntity<Page<OrderDto>> getAllOrder(@RequestParam(required = false) String customerName, @RequestParam(required = false) Long idOrder ,
                                                        Pageable pageable){
        return ResponseEntity.ok(orderService.getAllOrder(customerName, idOrder, pageable));
    }

}
