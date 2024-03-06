package com.blancspace.userrewardsservice.service;

import com.blancspace.userrewardsservice.entity.Reward;
import com.blancspace.userrewardsservice.entity.RuleSet;
import com.blancspace.userrewardsservice.entity.UserReward;
import com.blancspace.userrewardsservice.repository.RewardRepository;
import com.blancspace.userrewardsservice.repository.RuleSetRepository;
import com.blancspace.userrewardsservice.repository.UserRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserRewardService {
    @Autowired
    private UserRewardRepository userRewardRepository;
    @Autowired
    private RewardRepository rewardRepository;
    @Autowired
    private RuleSetRepository ruleSetRepository;

//    public UserReward fetchRewardsByUserId(String userId) {
//        return userRewardRepository.findByUser(userId);
//    }

    public UserReward logRewardToUserReward(String uuid) throws Exception {
        // Fetch user reward
        UserReward userReward = userRewardRepository.findByUuid(uuid);
        if (userReward == null) {
            userReward = new UserReward();
            userReward.setUuid(uuid);
            userReward.setDateStarted(new Date());

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
            throw new Exception("Reward limit reached for this QR code");
        }


        // Save the new reward
        userReward = userRewardRepository.save(userReward);

        newReward.setUserReward(userReward);
        // Save the new reward
        Reward reward = rewardRepository.save(newReward);


        return userReward;
    }


    public List<RuleSet> getActiveBatch(String batchId) {
        return ruleSetRepository.findActiveRuleSetByBatchId(batchId);
    }

}
