package com.blancspace.posservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transactions")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createdDate;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
