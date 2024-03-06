package com.blancspace.userrewardsservice.repository;

import com.blancspace.userrewardsservice.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {

}
