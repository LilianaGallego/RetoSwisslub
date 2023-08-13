package com.swisslub.appSwisslub.domain.service;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.repository.IMovementDetailRepository;
import com.swisslub.appSwisslub.domain.usecase.IMovementDetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovementDetailService implements IMovementDetailUseCase {
    private  final IMovementDetailRepository iMovementDetailRepository;

    @Override
    public ResponseMessageDto save(MovementDetailDto movementDetailDto) {
        iMovementDetailRepository.save(movementDetailDto);
        return new ResponseMessageDto("Detalle del movimiento registrado correctamente");
    }

    @Override
    public List<MovementDetailDto> getAll() {
        return iMovementDetailRepository.getAll();
    }

    @Override
    public Optional<MovementDetailDto> update(MovementDetailDto modifyMovementDetailDto, Long id) {
        Optional<MovementDetailDto> movementDetailBD = iMovementDetailRepository.getMovementDetailById(id);
        if(movementDetailBD.isEmpty()){
            return Optional.empty();
        }
        if(modifyMovementDetailDto.getMovementId() != null){
            movementDetailBD.get().setMovementId(modifyMovementDetailDto.getMovementId());
        }
        if(modifyMovementDetailDto.getItemCode() != null){
            movementDetailBD.get().setItemCode(modifyMovementDetailDto.getItemCode());
        }
        if(modifyMovementDetailDto.getQuantitySent() != 0){
            movementDetailBD.get().setQuantitySent(modifyMovementDetailDto.getQuantitySent());
        }
        return Optional.of(iMovementDetailRepository.update(movementDetailBD.get()));
    }
}
