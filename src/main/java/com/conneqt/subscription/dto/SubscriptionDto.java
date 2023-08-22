package com.conneqt.subscription.dto;

import com.conneqt.subscription.entity.Package;
import com.conneqt.subscription.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class SubscriptionDto {

    private Long subscriptionId;
    private User user;
    private Package package1;
    private LocalDate subscriptionDate;
    private LocalDate expiryDate;
}
