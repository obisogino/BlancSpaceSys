package com.blancspace.userrewardsservice.service;

import com.blancspace.userrewardsservice.entity.Reward;
import com.blancspace.userrewardsservice.entity.UserReward;
import com.blancspace.userrewardsservice.repository.RewardRepository;
import com.blancspace.userrewardsservice.repository.UserRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserRewardService {

    private final UserRewardRepository userRewardRepository;
    private final RewardRepository rewardRepository;

    @Autowired
    public UserRewardService(UserRewardRepository userRewardRepository, RewardRepository rewardRepository) {
        this.userRewardRepository = userRewardRepository;
        this.rewardRepository = rewardRepository;
    }

    public UserReward fetchRewardsByUserId(String userId) {
        return userRewardRepository.findByUser(userId);
    }

    public void logRewardToUserReward(String userId) throws Exception {
        // Fetch user reward
        UserReward userReward = userRewardRepository.findByUser(userId);
        if (userReward == null) {
            throw new Exception("User reward not found for user: " + userId);
        }

        // Find the highest count in the set of rewards
        Optional<Reward> maxCountReward = userReward.getItems().stream()
                .max(Comparator.comparingInt(Reward::getCnt));

        // Increment the count and save it to the newly logged reward
        int newCnt = maxCountReward.map(reward -> reward.getCnt() + 1).orElse(1);
        Reward newReward = new Reward();
        newReward.setCnt(newCnt);
        newReward.setUserReward(userReward);

        // Check if the newly logged reward reached its limit
        if (newCnt > userReward.getLmt()) {
            throw new Exception("Reward limit reached for user: " + userId);
        }

        // Save the new reward
        rewardRepository.save(newReward);
    }
}
