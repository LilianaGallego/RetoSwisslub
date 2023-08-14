package com.swisslub.appSwisslub.domain.repository;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.MovementWithDetailsDto;
import com.swisslub.appSwisslub.enums.StatusEnum;

import java.util.List;
import java.util.Optional;

public interface IMovementRepository {
    MovementDto save(MovementDto movementDto);
    List<MovementDto> getAll();
    Optional<MovementDto> getMovementById(Long id);
    List<MovementDto> getMovementByStatus(StatusEnum status);
    MovementDto update(MovementDto modifyMovementDto);
    void delete(Long id);
    MovementWithDetailsDto saveWithDetails(MovementWithDetailsDto movementWithDetailsDto);
}
