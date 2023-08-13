package com.swisslub.appSwisslub.persistence.mapper;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.persistence.entity.MovementDetailEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMovementDetailMapper {

    @Mapping(source = "movementEntity.id", target = "movementId")
    MovementDetailDto toMovementDetailDto(MovementDetailEntity movementDetailEntity);
    @InheritInverseConfiguration
    MovementDetailEntity toMovementDetailEntity(MovementDetailDto movementDto);

    List<MovementDetailDto> toMovementDetailsDto(List<MovementDetailEntity> movementDetailsEntity);
}
