package com.blancspace.userrewardsservice.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "rules")
public class RuleSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "batch_id")
    private String batchId;

    @Column(name = "expiration")
    private Date expiration;

    @Column(name = "keyAttrib")
    private String key;

    @Column(name = "valueAttrib")
    private String value;

    @Column(name = "isActive")
    private boolean isActive;

}