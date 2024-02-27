package com.blancspace.posservice.service;

import com.blancspace.posservice.dto.Order;
import com.blancspace.posservice.dto.OrderRequest;
import com.blancspace.posservice.entity.MenuItem;
import com.blancspace.posservice.repository.MenuItemRepository;
import com.blancspace.posservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    MenuItemRepository menuItemRepo;

    @Autowired
    TransactionRepository transactionRepo;

    public void makeOrder(OrderRequest orderRequest) {
        List<Long> orderIds = orderRequest.getOrders().stream().map(Order::getItemId).collect(Collectors.toList());
//        menuItemRepo.
    }
}
