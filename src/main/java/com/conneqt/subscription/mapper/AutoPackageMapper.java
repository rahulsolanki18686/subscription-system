package com.conneqt.subscription.mapper;


import com.conneqt.subscription.dto.PackageDto;
import com.conneqt.subscription.entity.Package;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoPackageMapper {

    AutoPackageMapper MAPPER = Mappers.getMapper(AutoPackageMapper.class);
    PackageDto mapToPackageDto(Package user);
    Package mapTOPackage(PackageDto userDto);
}
