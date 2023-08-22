package com.conneqt.subscription.service.impl;

import com.conneqt.subscription.dto.SubscriptionDto;
import com.conneqt.subscription.entity.Subscription;
import com.conneqt.subscription.exception.EmailAlreadyExistsException;
import com.conneqt.subscription.exception.ResourceNotFoundException;
import com.conneqt.subscription.mapper.AutoSubscriptionMapper;
import com.conneqt.subscription.repository.SubscriptionRepository;
import com.conneqt.subscription.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionRepository subscriptionRepository;
    @Override
    public SubscriptionDto createSubscription(SubscriptionDto subscriptionDto) {
//        Subscription subscription = SubscriptionMapper.mapTOSubscription(subscriptionDto);
        //   Subscription subscription = modelMapper.map(subscriptionDto,Subscription.class);

//        Optional<Subscription> optionalSubscription = subscriptionRepository.findByEmail(subscriptionDto.getEmail());
//        if(optionalSubscription.isPresent()){
//
//            throw new EmailAlreadyExistsException("Email Already Exists for Subscription");
//        }

        Subscription subscription = AutoSubscriptionMapper.MAPPER.mapTOSubscription(subscriptionDto);

        Subscription savedSubscription =subscriptionRepository.save(subscription);
        //  SubscriptionDto savedSubscriptionDto = SubscriptionMapper.mapToSubscriptionDto(savedSubscription);
        // SubscriptionDto savedSubscriptionDto = modelMapper.map(savedSubscription,SubscriptionDto.class);
        SubscriptionDto savedSubscriptionDto = AutoSubscriptionMapper.MAPPER.mapToSubscriptionDto(savedSubscription);
        return savedSubscriptionDto;
    }

    @Override
    public SubscriptionDto getSubscriptionById(Long subscriptionId) {

        Subscription subscription = subscriptionRepository.findById(subscriptionId).orElseThrow( () -> new ResourceNotFoundException("Subscription","id",subscriptionId));
        //Subscription subscription = optionalSubscription.get();
        //   return SubscriptionMapper.mapToSubscriptionDto(subscription);
        //  return modelMapper.map(subscription,SubscriptionDto.class);
        return AutoSubscriptionMapper.MAPPER.mapToSubscriptionDto(subscription);
    }

    @Override
    public List<SubscriptionDto> getAllSubscriptions() {

        List<Subscription> subscriptions = subscriptionRepository.findAll();
        //  return subscriptions.stream().map(SubscriptionMapper::mapToSubscriptionDto).collect(Collectors.toList());
        //   return subscriptions.stream().map((subscription) -> modelMapper.map(subscription,SubscriptionDto.class)).collect(Collectors.toList());
        return  subscriptions.stream().map((subscription) -> AutoSubscriptionMapper.MAPPER.mapToSubscriptionDto(subscription)).collect(Collectors.toList());
    }

    @Override
    public SubscriptionDto updateSubscription(SubscriptionDto subscription) {
        Subscription existingSubscription = subscriptionRepository.findById(subscription.getSubscriptionId()).orElseThrow(
                () -> new ResourceNotFoundException("Subscription","id",subscription.getSubscriptionId())
        );

        existingSubscription.setUser(subscription.getUser());
        existingSubscription.setPackage1(subscription.getPackage1());
        existingSubscription.setSubscriptionDate(LocalDate.now());
        existingSubscription.setExpiryDate(LocalDateTime.now().plusYears(1).toLocalDate());
        Subscription updatedSubscription = subscriptionRepository.save(existingSubscription);

        // return SubscriptionMapper.mapToSubscriptionDto(updatedSubscription);
        // return modelMapper.map(updatedSubscription, SubscriptionDto.class);
        return AutoSubscriptionMapper.MAPPER.mapToSubscriptionDto(updatedSubscription);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        Subscription existingSubscription = subscriptionRepository.findById(subscriptionId).orElseThrow(
                () -> new ResourceNotFoundException("Subscription","id",subscriptionId)
        );
        subscriptionRepository.deleteById(subscriptionId);
    }
}
