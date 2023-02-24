package com.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequest {
    String id;
    @NonNull
    private String orderinfo;


    @NonNull
    private String city;
    @NonNull
    private long pincode;
    @NonNull
    private Integer quantity;
    private List<String> productid;
    @NonNull
    private String paymentMode;
    private String OrderStatus;

}
