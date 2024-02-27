package com.blancspace.userrewardsservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "UserReward")
public class UserReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user")
    private String user;

    @Column(name = "lmt")
    private int lmt;

    @Column(name = "dateStarted")
    private Date dateStarted;

    @Column(name = "dateFinished")
    private Date dateFinished;

    @Column(name = "isFull")
    private boolean isFull;

    @Column(name = "rewardPrize")
    private String rewardPrize;

    @Column(name = "isActive")
    private boolean isActive;

    @OneToMany(mappedBy="userReward")
    private Set<Reward> items;

}
