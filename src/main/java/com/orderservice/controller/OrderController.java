package com.orderservice.controller;

import com.orderservice.dto.UpdateOrderRequest;
import com.orderservice.entity.OrderInformation;
import com.orderservice.services.OrderService;
import com.orderservice.dto.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")

public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{id}")
    public OrderInformation getSingleOrder(@PathVariable Integer id) {
        logger.info("Request for getSingleOrder for orderid {}", id);
        return orderService.getSingleOrder(id);
    }

    @PostMapping("/order")

    public OrderInformation createDynamicMessage(
            @RequestBody OrderRequest request
    ) {
        return orderService.creatOrder(request);
    }

    @DeleteMapping("order/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Integer id) {
        return orderService.deleteOrderById(id);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<OrderInformation> updateOrder(
            @PathVariable Integer id,
            @RequestBody UpdateOrderRequest request
            ){
        return orderService.updateOrder(id,request);
    }
}


