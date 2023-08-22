package com.conneqt.subscription.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Package {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
 //   @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
   // @JoinColumn(name = "plan_id")
    private Plan plan;



}
