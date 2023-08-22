package com.conneqt.subscription.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plan {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;

    private String planDuration;

    @ManyToOne
    private Channel channel;

}
