package com.blancspace.userrewardsservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "UserReward")
public class UserReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user")
    private String user;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "lmt")
    private int lmt;

    @Column(name = "cnt")
    private int cnt;

    @Column(name = "dateStarted")
    private Date dateStarted;

    @Column(name = "dateFinished")
    private Date dateFinished;

    @Column(name = "status")
    private String status;

    @Column(name = "isActive")
    private boolean isActive;

    @OneToMany(targetEntity=Reward.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="reward_fk", referencedColumnName = "id")
    private Set<Reward> rewards;


}
