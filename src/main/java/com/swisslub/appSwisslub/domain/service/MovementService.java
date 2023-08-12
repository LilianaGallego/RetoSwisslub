package com.swisslub.appSwisslub.domain.service;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.repository.IMovementRepository;
import com.swisslub.appSwisslub.domain.usecase.IMovementUseCase;
import com.swisslub.appSwisslub.enums.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovementService implements IMovementUseCase {
    private  final IMovementRepository iMovementRepository;
    @Override
    public ResponseMessageDto save(MovementDto movementDto) {
        movementDto.setStatus(StatusEnum.P);
        iMovementRepository.save(movementDto);
        return new ResponseMessageDto("Movimiento registrado correctamente");
    }
}
