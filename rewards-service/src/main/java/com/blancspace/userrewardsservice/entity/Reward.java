package com.blancspace.userrewardsservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="user_reward_id")
//    private UserReward userReward;
}
