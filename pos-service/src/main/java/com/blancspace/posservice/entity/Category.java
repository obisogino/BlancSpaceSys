package com.blancspace.posservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "menu_categories")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Group> groups;

    @Column(columnDefinition="tinyint(1) default 1")
    private Boolean isActive;

    @CreatedDate
    private Date createdDate;
}
