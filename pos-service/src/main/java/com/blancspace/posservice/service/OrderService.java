package com.blancspace.posservice.service;

import com.blancspace.posservice.dto.OrderRequest;
import com.blancspace.posservice.entity.MenuItem;
import com.blancspace.posservice.repository.MenuItemRepository;
import com.blancspace.posservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    MenuItemRepository menuItemRepo;

    @Autowired
    TransactionRepository transactionRepo;

    public void makeOrder(OrderRequest orderRequest) {
        
    }
}
