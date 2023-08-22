package com.conneqt.subscription.mapper;


import com.conneqt.subscription.dto.SubscriptionDto;
import com.conneqt.subscription.entity.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoSubscriptionMapper {

    AutoSubscriptionMapper MAPPER = Mappers.getMapper(AutoSubscriptionMapper.class);
    SubscriptionDto mapToSubscriptionDto(Subscription user);
    Subscription mapTOSubscription(SubscriptionDto userDto);
}
