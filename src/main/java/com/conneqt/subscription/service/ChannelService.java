package com.conneqt.subscription.service;

import com.conneqt.subscription.dto.ChannelDto;

import java.util.List;

public interface ChannelService {

    ChannelDto createChannel(ChannelDto userDto);
    ChannelDto getChannelById(Long userId);

    List<ChannelDto> getAllChannels();

    ChannelDto updateChannel(ChannelDto userDto);

    void deleteChannel(Long userId);
}
