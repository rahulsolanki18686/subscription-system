package com.conneqt.subscription.repository;

import com.conneqt.subscription.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package,Long> {
}
