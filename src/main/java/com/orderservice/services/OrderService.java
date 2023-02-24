package com.orderservice.services;


import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.UpdateOrderRequest;
import com.orderservice.entity.OrderInformation;
import com.orderservice.exception.OrderNotFoundException;
import com.orderservice.repository.OrderInformationRepository;
import com.orderservice.util.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
    Logger logger= LoggerFactory.getLogger(OrderService.class);


    @Autowired
    private OrderInformationRepository repository;
    public OrderInformation creatOrder(OrderRequest request){

        OrderInformation orderInfo= new OrderInformation();

        orderInfo.setOrderInfo(request.getOrderinfo());
        orderInfo.setOrderDateTime(LocalDateTime.now());
        orderInfo.setCity(request.getCity());
        orderInfo.setPinCode(request.getPincode());
        orderInfo.setPaymentMode(request.getPaymentMode());
        orderInfo.setQuantity(request.getQuantity());
        orderInfo.setOrderStatus(OrderStatus.CREATED.getValue());
        return repository.save(orderInfo);


    }
    public OrderInformation getSingleOrder(Integer id)
    {
        logger.info("Exceuting getSingleOrder into orderservice for orderid {}",id);
        System.out.println("Called for getSingleOrder for orderid :"+id);
       return repository.findById(id)
               .orElseThrow(()-> new OrderNotFoundException("Order id is not found"));
    }

    public ResponseEntity<String> deleteOrderById(Integer id) {
        repository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException("Order id is not found"));

      repository.deleteById(id);
      return new ResponseEntity<>("order has been removed successfully",HttpStatus.OK);
    }

    public ResponseEntity<OrderInformation> updateOrder(Integer id, UpdateOrderRequest request) {
        logger.info("Update request :{} for id: {}  ",request,id);
       OrderInformation orderInformation= repository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException("Order id is not found for update"));
       orderInformation.setOrderStatus(request.getOrderStatus());
       repository.save(orderInformation);
       return new ResponseEntity<>(orderInformation,HttpStatus.ACCEPTED);

    }
}
