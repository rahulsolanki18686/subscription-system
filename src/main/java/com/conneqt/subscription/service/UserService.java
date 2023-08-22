package com.conneqt.subscription.service;

import com.conneqt.subscription.dto.UserDto;
import com.conneqt.subscription.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);

    Optional<User> findByEmail(String email);
}
