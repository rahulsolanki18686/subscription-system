package com.conneqt.subscription.service;

import com.conneqt.subscription.dto.PackageDto;

import java.util.List;

public interface PackageService {

    PackageDto createPackage(PackageDto userDto);
    PackageDto getPackageById(Long userId);

    List<PackageDto> getAllPackages();

    PackageDto updatePackage(PackageDto userDto);

    void deletePackage(Long userId);
}
