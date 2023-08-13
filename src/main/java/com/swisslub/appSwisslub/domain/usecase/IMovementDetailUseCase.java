package com.swisslub.appSwisslub.domain.usecase;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IMovementDetailUseCase {
    ResponseMessageDto save(MovementDetailDto movementDetailDto);
    List<MovementDetailDto> getAll();
    Optional<MovementDetailDto> update(MovementDetailDto modifyMovementDetailDto, Long id);
    ResponseEntity<?> delete(Long id);
    Optional<MovementDetailDto> getMovementDetailById(Long id);
}
