package com.conneqt.subscription.mapper;


import com.conneqt.subscription.dto.ChannelDto;
import com.conneqt.subscription.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoChannelMapper {

    AutoChannelMapper MAPPER = Mappers.getMapper(AutoChannelMapper.class);
    ChannelDto mapToChannelDto(Channel user);
    Channel mapTOChannel(ChannelDto userDto);
}
