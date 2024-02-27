package com.blancspace.posservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    List<Order> orders;

    Double amountPaid;

    Double amountTendered;

    Double amountChange;

}
