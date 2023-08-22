package com.conneqt.subscription.dto;

import com.conneqt.subscription.entity.Channel;
import com.conneqt.subscription.entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PackageDto {

    private Long id;
    private String name;
    private Channel channel;
    private Plan plan;
}
