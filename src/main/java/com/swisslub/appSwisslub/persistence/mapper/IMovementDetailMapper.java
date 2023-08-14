package com.swisslub.appSwisslub.persistence.mapper;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMovementDetailDto;
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

    @Mappings({
            @Mapping(source = "movementEntity.id", target = "movementId"),
            @Mapping(source = "movementEntity.companyId", target = "companyId"),
            @Mapping(source = "movementEntity.wineryOriginCode", target = "wineryOriginCode"),
            @Mapping(source = "movementEntity.wineryDestinationCode", target = "wineryDestinationCode")}

    )
    ResponseMovementDetailDto toResponseMovementDetailDto(MovementDetailEntity movementDetailEntity);
    List<ResponseMovementDetailDto> toResponseMovementDetailDtoList(List<MovementDetailEntity> movementDetailsEntity);
}
