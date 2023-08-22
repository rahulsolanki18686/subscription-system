package com.conneqt.subscription.mapper;


import com.conneqt.subscription.dto.UserDto;
import com.conneqt.subscription.entity.User;

public class UserMapper {
    //Convert User JPA entity into UserDto
    public static UserDto mapToUserDto(User user){

        UserDto userDto = new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
        return userDto;
    }
    //Convert UserDto into User JPA entity
    public static User mapTOUser(UserDto userDto){
        User user = new User(userDto.getUserId(),
                userDto.getUsername(),
                userDto.getEmail()
        );
        return user;

    }
}