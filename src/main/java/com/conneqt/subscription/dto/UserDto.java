package com.conneqt.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private Long userId;

    private String username;
    private String email;
}
