package com.blancspace.userrewardsservice.controller;

import com.blancspace.userrewardsservice.entity.UserReward;
import com.blancspace.userrewardsservice.service.UserRewardService;
import com.blancspace.userrewardsservice.util.UserRewardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserRewardController {
    private final UserRewardService userRewardService;

    @Autowired
    public UserRewardController(UserRewardService userRewardService) {
        this.userRewardService = userRewardService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/generate-uuid")
    public ResponseEntity<String> generateUuid() {
        // generate and return UUID

        return new ResponseEntity<>(UserRewardUtils.generateUUID(), HttpStatus.OK);
//        return
    }

    @RequestMapping(method = RequestMethod.POST, value = "/log-reward/{uuid}")

    public ResponseEntity<UserReward> logReward(@PathVariable String uuid) {
        try {
            UserReward userReward = userRewardService.logRewardToUserReward(uuid);
            return new ResponseEntity<>(userReward, HttpStatus.OK);
        } catch (Exception e) {
            return null;
//            return new ResponseEntity<>("Failed to log reward: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
