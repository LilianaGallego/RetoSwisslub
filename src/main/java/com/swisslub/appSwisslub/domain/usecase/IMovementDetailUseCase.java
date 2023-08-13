package com.swisslub.appSwisslub.domain.usecase;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;

public interface IMovementDetailUseCase {
    ResponseMessageDto save(MovementDetailDto movementDetailDto);
}
