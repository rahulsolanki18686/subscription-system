package com.conneqt.subscription.service;

import com.conneqt.subscription.dto.SubscriptionDto;

import java.util.List;

public interface SubscriptionService {

    SubscriptionDto createSubscription(SubscriptionDto userDto);
    SubscriptionDto getSubscriptionById(Long userId);

    List<SubscriptionDto> getAllSubscriptions();

    SubscriptionDto updateSubscription(SubscriptionDto userDto);

    void deleteSubscription(Long userId);
}
