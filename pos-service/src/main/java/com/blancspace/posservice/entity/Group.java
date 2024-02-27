package com.blancspace.posservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "menu_groups")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;

    @Column(columnDefinition="tinyint(1) default 1")
    private Boolean isActive;

    @CreatedDate
    private Date createdDate;
}