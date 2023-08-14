package com.swisslub.appSwisslub.persistence.mapper;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.MovementWithDetailsDto;
import com.swisslub.appSwisslub.persistence.entity.MovementEntity;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring", uses= {IMovementDetailMapper.class})
public interface IMovementMapper {

    MovementDto toMovementDto(MovementEntity movementEntity);
    MovementEntity toMovementEntity(MovementDto movementDto);

    List<MovementDto> toMovementsDto(List<MovementEntity> movementEntities);

    MovementWithDetailsDto toMovementWithDetailsDto(MovementEntity movementEntity);
    MovementEntity toMovementEntityWithDetails(MovementWithDetailsDto movementWithDetailsDto);
}
