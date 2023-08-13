package com.swisslub.appSwisslub.domain.usecase;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IMovementUseCase {
    ResponseMessageDto save(MovementDto movementDto);
    List<MovementDto> getAll();
    Optional<MovementDto> update(MovementDto modifyMovementDto, Long id);
    ResponseEntity<?> delete(Long id);
    Optional<MovementDto> getMovementById(Long id);
}
