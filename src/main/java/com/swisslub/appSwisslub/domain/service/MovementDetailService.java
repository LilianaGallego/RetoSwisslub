package com.swisslub.appSwisslub.domain.service;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.repository.IMovementDetailRepository;
import com.swisslub.appSwisslub.domain.usecase.IMovementDetailUseCase;
import com.swisslub.appSwisslub.enums.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<MovementDetailDto> movementDetailBD = iMovementDetailRepository.getMovementDetailById(id);
        HashMap<String, Object> json = new HashMap<>();
        if(movementDetailBD.isPresent()){
            iMovementDetailRepository.delete(id);
            json.put("Mensaje", "Detalle del movimiento eliminado correctamente");
            return new ResponseEntity<>(json, HttpStatus.OK);
        }
        json.put("Mensaje", "El detalle del movimiento no ha sido encontrado");
        return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional<MovementDetailDto> getMovementDetailById(Long id) {
        return iMovementDetailRepository.getMovementDetailById(id);
    }

    @Override
    public List<MovementDetailDto> getMovementDetailsByStatus(StatusEnum status) {
        return iMovementDetailRepository.getByStatus(status);
    }
}
