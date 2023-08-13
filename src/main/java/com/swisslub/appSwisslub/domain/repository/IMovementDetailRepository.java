package com.swisslub.appSwisslub.domain.repository;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.enums.StatusEnum;

import java.util.List;
import java.util.Optional;

public interface IMovementDetailRepository {
    MovementDetailDto save(MovementDetailDto movementDetailDto);
    List<MovementDetailDto> getAll();
    Optional<MovementDetailDto> getMovementDetailById(Long id);
    List<MovementDetailDto> getByStatus(StatusEnum status);
    MovementDetailDto update(MovementDetailDto modifyMovementDetailDto);
    void delete(Long id);
}
