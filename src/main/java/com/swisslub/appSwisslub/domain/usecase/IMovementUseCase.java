package com.swisslub.appSwisslub.domain.usecase;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;

import java.util.List;

public interface IMovementUseCase {
    ResponseMessageDto save(MovementDto movementDto);
    List<MovementDto> getAll();
}
