package com.blancspace.userrewardsservice.controller;

import com.blancspace.userrewardsservice.dto.CreateUserRewardDto;
import com.blancspace.userrewardsservice.dto.ResponseDto;
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

    @RequestMapping(method = RequestMethod.POST, value = "/reward-generate")
    public ResponseEntity<String> generateUuid(@RequestBody CreateUserRewardDto createUserRewardDto) {
        return new ResponseEntity<>(UserRewardUtils.generateUUID(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reward/{uuid}")
    public ResponseEntity<ResponseDto<UserReward>> logReward(@PathVariable String uuid) {
        try {

            UserReward userReward = userRewardService.logRewardToUserReward(uuid);

            ResponseDto<UserReward> responseDto = new ResponseDto<>();
            responseDto.setData(userReward);

            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            ResponseDto<UserReward> responseDto = new ResponseDto<>();
            responseDto.setErrorMessage(e.getMessage());

            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reward/{uuid}")
    public ResponseEntity<ResponseDto<UserReward>> getRewardFromUuid(@PathVariable String uuid) {
        try {

            UserReward userReward = userRewardService.getActiveUserRewardByUuid(uuid);

            ResponseDto<UserReward> responseDto = new ResponseDto<>();
            responseDto.setData(userReward);

            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            ResponseDto<UserReward> responseDto = new ResponseDto<>();
            responseDto.setErrorMessage(e.getMessage());

            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
