package com.conneqt.subscription.service.impl;

import com.conneqt.subscription.dto.ChannelDto;
import com.conneqt.subscription.entity.Channel;
import com.conneqt.subscription.exception.EmailAlreadyExistsException;
import com.conneqt.subscription.exception.ResourceNotFoundException;
import com.conneqt.subscription.mapper.AutoChannelMapper;
import com.conneqt.subscription.repository.ChannelRepository;
import com.conneqt.subscription.service.ChannelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private ChannelRepository userRepository;
    @Override
    public ChannelDto createChannel(ChannelDto userDto) {
//        Channel user = ChannelMapper.mapTOChannel(userDto);
        //   Channel user = modelMapper.map(userDto,Channel.class);

        Optional<Channel> optionalChannel = userRepository.findByName(userDto.getName());
        if(optionalChannel.isPresent()){

            throw new EmailAlreadyExistsException("Email Already Exists for Channel");
        }

        Channel user = AutoChannelMapper.MAPPER.mapTOChannel(userDto);

        Channel savedChannel =userRepository.save(user);
        //  ChannelDto savedChannelDto = ChannelMapper.mapToChannelDto(savedChannel);
        // ChannelDto savedChannelDto = modelMapper.map(savedChannel,ChannelDto.class);
        ChannelDto savedChannelDto = AutoChannelMapper.MAPPER.mapToChannelDto(savedChannel);
        return savedChannelDto;
    }

    @Override
    public ChannelDto getChannelById(Long userId) {

        Channel user = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("Channel","id",userId));
        //Channel user = optionalChannel.get();
        //   return ChannelMapper.mapToChannelDto(user);
        //  return modelMapper.map(user,ChannelDto.class);
        return AutoChannelMapper.MAPPER.mapToChannelDto(user);
    }

    @Override
    public List<ChannelDto> getAllChannels() {

        List<Channel> users = userRepository.findAll();
        //  return users.stream().map(ChannelMapper::mapToChannelDto).collect(Collectors.toList());
        //   return users.stream().map((user) -> modelMapper.map(user,ChannelDto.class)).collect(Collectors.toList());
        return  users.stream().map((user) -> AutoChannelMapper.MAPPER.mapToChannelDto(user)).collect(Collectors.toList());
    }

    @Override
    public ChannelDto updateChannel(ChannelDto user) {
        Channel existingChannel = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Channel","id",user.getId())
        );

        existingChannel.setName(user.getName());
        existingChannel.setCost(user.getCost());
        existingChannel.setLanguage(user.getLanguage());

        Channel updatedChannel = userRepository.save(existingChannel);

        // return ChannelMapper.mapToChannelDto(updatedChannel);
        // return modelMapper.map(updatedChannel, ChannelDto.class);
        return AutoChannelMapper.MAPPER.mapToChannelDto(updatedChannel);
    }

    @Override
    public void deleteChannel(Long userId) {
        Channel existingChannel = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("Channel","id",userId)
        );
        userRepository.deleteById(userId);
    }
}
