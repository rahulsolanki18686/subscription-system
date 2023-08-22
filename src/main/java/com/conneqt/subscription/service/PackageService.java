package com.conneqt.subscription.service;

import com.conneqt.subscription.dto.PackageDto;
import com.conneqt.subscription.entity.Package;

import java.util.List;
import java.util.Optional;

public interface PackageService {

    PackageDto createPackage(PackageDto userDto);
    PackageDto getPackageById(Long userId);

    List<PackageDto> getAllPackages();

    PackageDto updatePackage(PackageDto userDto);

    void deletePackage(Long userId);

    Optional<Package> findByName(String name);
}
