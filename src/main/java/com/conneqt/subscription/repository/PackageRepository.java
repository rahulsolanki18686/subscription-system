package com.conneqt.subscription.repository;

import com.conneqt.subscription.entity.Package;
import com.conneqt.subscription.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageRepository extends JpaRepository<Package,Long> {
    Optional<Package> findByName(String name);
}
