package com.conneqt.subscription.dto;

import com.conneqt.subscription.entity.Channel;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PlanDto {

    private Long id;

    private String name;

    private Double price;

    private String planDuration;

    private Channel channel;
}
