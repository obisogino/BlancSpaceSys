package com.blancspace.userrewardsservice.repository;

import com.blancspace.userrewardsservice.entity.UserReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRewardRepository extends JpaRepository<UserReward, Integer> {
//    UserReward findByUser(String user);

    UserReward findByUuid(String uuid);

}