package com.conneqt.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ChannelDto {

    private Long id;

    private String name;

    private Double cost;

    private String language;
}
