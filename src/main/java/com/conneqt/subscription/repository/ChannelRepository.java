package com.conneqt.subscription.repository;

import com.conneqt.subscription.entity.Channel;
import com.conneqt.subscription.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChannelRepository extends JpaRepository<Channel,Long> {
    Optional<Channel> findByName(String name);
}
