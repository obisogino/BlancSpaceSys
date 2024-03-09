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

            //populate user reward
            userReward = new UserReward();
            userReward.setUuid(uuid);
            userReward.setDateStarted(new Date());

            // rules
            userReward.setUser("test-user");
            userReward.setRewardPrize("test-prize");
            userReward.setFull(false);
            userReward.setActive(true);
            userReward.setLmt(5);

            // rewards
            // complete setting of reward
            Reward reward = new Reward();
            reward.setDate(new Date());
            reward.setCnt(1);

            userReward.setRewards(new HashSet<>(Set.of(reward)));
            userReward = userRewardRepository.save(userReward);

        } else {

            // Find the highest count in the set of rewards
            Optional<Reward> maxCountReward = userReward.getRewards().stream()
                    .max(Comparator.comparingInt(Reward::getCnt));

            // Increment the count and save it to the newly logged reward
            int newCnt = maxCountReward.map(reward -> reward.getCnt() + 1).orElse(1);
            Reward newReward = new Reward();
            newReward.setDate(new Date());
            newReward.setCnt(newCnt);
            userReward.setCnt(newCnt);

            if (newCnt > userReward.getLmt()) {
                throw new Exception("Reward limit reached for this QR code");
            }

            userReward.getRewards().add(newReward);
            // Save the new reward
            userReward = userRewardRepository.save(userReward);


        }
        return userRewardRepository.findById(userReward.getId()).get();
    }


    public List<RuleSet> getActiveBatch(String batchId) {
        return ruleSetRepository.findActiveRuleSetByBatchId(batchId);
    }

}
