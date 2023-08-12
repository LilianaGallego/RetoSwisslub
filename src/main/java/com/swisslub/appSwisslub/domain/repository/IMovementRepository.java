package com.swisslub.appSwisslub.domain.repository;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.enums.StatusEnum;

import java.util.List;
import java.util.Optional;

public interface IMovementRepository {
    MovementDto save(MovementDto movementDto);
    List<MovementDto> getAll();
    Optional<MovementDto> getMovementById(Long id);
    Optional<MovementDto> getMovementByStatus(StatusEnum status);
    void delete(Long id);
}
