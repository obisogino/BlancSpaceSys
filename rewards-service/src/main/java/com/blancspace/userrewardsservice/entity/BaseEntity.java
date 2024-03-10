package com.blancspace.userrewardsservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreated")
    Timestamp dateCreated;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "dateUpdated")
    Timestamp dateUpdated;

    @Column(name = "branch")
    String branch;

    @Column(name = "createdBy")
    String createdBy;

    @Column(name = "updatedBy")
    String updatedBy;



}
