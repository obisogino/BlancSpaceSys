package com.blancspace.posservice.dto;


import lombok.Data;

@Data
public class Order {

    Long itemId;

    String itemName;

    String itemDesc;

    String discountNote;

    Double amount;
}
