package com.swisslub.appSwisslub.domain.service;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.repository.IMovementRepository;
import com.swisslub.appSwisslub.domain.usecase.IMovementUseCase;
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
public class MovementService implements IMovementUseCase {
    private  final IMovementRepository iMovementRepository;
    @Override
    public ResponseMessageDto save(MovementDto movementDto) {
        movementDto.setStatus(StatusEnum.P);
        iMovementRepository.save(movementDto);
        return new ResponseMessageDto("Movimiento registrado correctamente");
    }

    @Override
    public List<MovementDto> getAll() {
        return iMovementRepository.getAll();
    }

    @Override
    public Optional<MovementDto> update(MovementDto modifyMovementDto, Long id) {
        Optional<MovementDto> movementBD = iMovementRepository.getMovementById(id);
        if (movementBD.isEmpty()){
            return Optional.empty();
        }
        if (modifyMovementDto.getCompanyId()!= null) {
            movementBD.get().setCompanyId(modifyMovementDto.getCompanyId());
        }
        if (modifyMovementDto.getDescription()!= null) {
            movementBD.get().setDescription(modifyMovementDto.getDescription());
        }
        if (modifyMovementDto.getWineryOriginCode()!= null) {
            movementBD.get().setWineryOriginCode(modifyMovementDto.getWineryOriginCode());
        }
        if (modifyMovementDto.getWineryDestinationCode()!= null) {
            movementBD.get().setWineryDestinationCode(modifyMovementDto.getWineryDestinationCode());
        }
        if (modifyMovementDto.getCreationDate()!= null) {
            movementBD.get().setCreationDate(modifyMovementDto.getCreationDate());
        }
        if (modifyMovementDto.getDeliveryDate()!= null) {
            movementBD.get().setDeliveryDate(modifyMovementDto.getDeliveryDate());
        }
        if (modifyMovementDto.getStatus()!= null) {
            movementBD.get().setStatus(modifyMovementDto.getStatus());
        }

        return Optional.of(iMovementRepository.save(movementBD.get()));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<MovementDto> movementBD = iMovementRepository.getMovementById(id);
        HashMap<String, Object> json = new HashMap<>();
        if(movementBD.isPresent()){
            iMovementRepository.delete(id);
            json.put("Mensaje", "Movimiento eliminado correctamente");
            return new ResponseEntity<>(json, HttpStatus.OK);
        }
        json.put("Mensaje", "El movimiento no ha sido encontrado");
        return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
    }

    @Override
    public Optional<MovementDto> getMovementById(Long id) {
        Optional<MovementDto> movementBD = iMovementRepository.getMovementById(id);
        if (movementBD.isEmpty()){
            return Optional.empty();
        }
        return movementBD;
    }
}
