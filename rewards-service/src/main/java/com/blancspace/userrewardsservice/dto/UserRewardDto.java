package com.blancspace.userrewardsservice.dto;

import com.blancspace.userrewardsservice.entity.UserReward;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRewardDto extends UserReward {

    private String errorMessage;


}
