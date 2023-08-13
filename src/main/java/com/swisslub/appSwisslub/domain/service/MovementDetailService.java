package com.swisslub.appSwisslub.domain.service;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.repository.IMovementDetailRepository;
import com.swisslub.appSwisslub.domain.usecase.IMovementDetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovementDetailService implements IMovementDetailUseCase {
    private  final IMovementDetailRepository iMovementDetailRepository;

    @Override
    public ResponseMessageDto save(MovementDetailDto movementDetailDto) {
        iMovementDetailRepository.save(movementDetailDto);
        return new ResponseMessageDto("Detalle del movimiento registrado correctamente");
    }
}
