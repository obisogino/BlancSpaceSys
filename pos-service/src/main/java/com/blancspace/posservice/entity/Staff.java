package com.blancspace.posservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "staff")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "completeName", nullable = false)
    private String completeName;

    @Column(name = "nickName", unique = true)
    private String nickName;

    @Column(name = "perHourRate")
    private Double perHourRate;

    @Column(columnDefinition="tinyint(1) default 1")
    private Boolean isActive;

    @Column(name = "staffId")
    private String staffId;
}
