package com.blancspace.posservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tickets")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salePrice")
    private Double salePrice;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @CreatedDate
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Transaction transaction;
}
