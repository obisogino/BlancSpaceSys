package com.blancspace.posservice.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "menu_items")
@EntityListeners(AuditingEntityListener.class)
@Data
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(columnDefinition="tinyint(1) default 1")
    private Boolean isActive;

    @CreatedDate
    private Date createdDate;
}