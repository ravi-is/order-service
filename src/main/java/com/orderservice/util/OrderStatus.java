package com.orderservice.util;

public enum OrderStatus {

    CREATED("CREATED"),
    IN_TANSITE("IN_TRANSITE"),
    OUT_FOR_DILIVERY("OUT_FOR_DILIVERY"),
    DELIVERED("DELIVERED");
    String value;
    OrderStatus(String value){

    }
    public String getValue(){
        return value;
    }
}

