package com.conneqt.subscription.mapper;


import com.conneqt.subscription.dto.UserDto;
import com.conneqt.subscription.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDto mapToUserDto(User user);
    User mapTOUser(UserDto userDto);
}
