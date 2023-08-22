package com.conneqt.subscription.service.impl;

import com.conneqt.subscription.dto.PackageDto;
import com.conneqt.subscription.entity.Package;
import com.conneqt.subscription.exception.EmailAlreadyExistsException;
import com.conneqt.subscription.exception.ResourceNotFoundException;
import com.conneqt.subscription.mapper.AutoPackageMapper;
import com.conneqt.subscription.repository.PackageRepository;
import com.conneqt.subscription.service.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {

    private PackageRepository package1Repository;
    @Override
    public PackageDto createPackage(PackageDto package1Dto) {
//        Package package1 = PackageMapper.mapTOPackage(package1Dto);
        //   Package package1 = modelMapper.map(package1Dto,Package.class);

//        Optional<Package> optionalPackage = package1Repository.findByEmail(package1Dto.getEmail());
//        if(optionalPackage.isPresent()){
//
//            throw new EmailAlreadyExistsException("Email Already Exists for Package");
//        }

        Package package1 = AutoPackageMapper.MAPPER.mapTOPackage(package1Dto);

        Package savedPackage =package1Repository.save(package1);
        //  PackageDto savedPackageDto = PackageMapper.mapToPackageDto(savedPackage);
        // PackageDto savedPackageDto = modelMapper.map(savedPackage,PackageDto.class);
        PackageDto savedPackageDto = AutoPackageMapper.MAPPER.mapToPackageDto(savedPackage);
        return savedPackageDto;
    }

    @Override
    public PackageDto getPackageById(Long package1Id) {

        Package package1 = package1Repository.findById(package1Id).orElseThrow( () -> new ResourceNotFoundException("Package","id",package1Id));
        //Package package1 = optionalPackage.get();
        //   return PackageMapper.mapToPackageDto(package1);
        //  return modelMapper.map(package1,PackageDto.class);
        return AutoPackageMapper.MAPPER.mapToPackageDto(package1);
    }

    @Override
    public List<PackageDto> getAllPackages() {

        List<Package> package1s = package1Repository.findAll();
        //  return package1s.stream().map(PackageMapper::mapToPackageDto).collect(Collectors.toList());
        //   return package1s.stream().map((package1) -> modelMapper.map(package1,PackageDto.class)).collect(Collectors.toList());
        return  package1s.stream().map((package1) -> AutoPackageMapper.MAPPER.mapToPackageDto(package1)).collect(Collectors.toList());
    }

    @Override
    public PackageDto updatePackage(PackageDto package1) {
        Package existingPackage = package1Repository.findById(package1.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Package","id",package1.getId())
        );

        existingPackage.setChannel(package1.getChannel());
        existingPackage.setPlan(package1.getPlan());
        Package updatedPackage = package1Repository.save(existingPackage);

        // return PackageMapper.mapToPackageDto(updatedPackage);
        // return modelMapper.map(updatedPackage, PackageDto.class);
        return AutoPackageMapper.MAPPER.mapToPackageDto(updatedPackage);
    }

    @Override
    public void deletePackage(Long package1Id) {
        Package existingPackage = package1Repository.findById(package1Id).orElseThrow(
                () -> new ResourceNotFoundException("Package","id",package1Id)
        );
        package1Repository.deleteById(package1Id);
    }

    @Override
    public Optional<Package> findByName(String name) {
        return package1Repository.findByName(name);
    }
}
