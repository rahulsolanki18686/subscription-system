package com.conneqt.subscription.service.impl;

import com.conneqt.subscription.dto.UserDto;
import com.conneqt.subscription.entity.User;
import com.conneqt.subscription.exception.EmailAlreadyExistsException;
import com.conneqt.subscription.exception.ResourceNotFoundException;
import com.conneqt.subscription.mapper.AutoUserMapper;
import com.conneqt.subscription.mapper.UserMapper;
import com.conneqt.subscription.repository.UserRepository;
import com.conneqt.subscription.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
//        User user = UserMapper.mapTOUser(userDto);
        //   User user = modelMapper.map(userDto,User.class);

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){

            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }

        User user = AutoUserMapper.MAPPER.mapTOUser(userDto);

        User savedUser =userRepository.save(user);
        //  UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        // UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User","id",userId));
        //User user = optionalUser.get();
        //   return UserMapper.mapToUserDto(user);
        //  return modelMapper.map(user,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        //  return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        //   return users.stream().map((user) -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return  users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("User","id",user.getUserId())
        );

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

        // return UserMapper.mapToUserDto(updatedUser);
        // return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id",userId)
        );
        userRepository.deleteById(userId);
    }
}
