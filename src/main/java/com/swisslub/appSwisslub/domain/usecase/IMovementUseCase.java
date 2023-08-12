package com.swisslub.appSwisslub.domain.usecase;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;

public interface IMovementUseCase {
    ResponseMessageDto save(MovementDto movementDto);
}
