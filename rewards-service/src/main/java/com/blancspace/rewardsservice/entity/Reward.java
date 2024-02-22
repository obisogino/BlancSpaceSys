package com.blancspace.rewardsservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Reward")
public class Reward
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cnt")
    private int cnt;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="user_reward_id", nullable=false)
    private UserReward userReward;
}
