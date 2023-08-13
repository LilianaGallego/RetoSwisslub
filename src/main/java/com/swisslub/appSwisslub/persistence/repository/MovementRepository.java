package com.swisslub.appSwisslub.persistence.repository;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.repository.IMovementRepository;
import com.swisslub.appSwisslub.enums.StatusEnum;
import com.swisslub.appSwisslub.persistence.crud.IMovementCrudRepository;
import com.swisslub.appSwisslub.persistence.entity.MovementEntity;
import com.swisslub.appSwisslub.persistence.mapper.IMovementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MovementRepository implements IMovementRepository {
    private final IMovementCrudRepository iMovementCrudRepository;
    private final IMovementMapper iMovementMapper;

    @Override
    public MovementDto save(MovementDto movementDto) {
        MovementEntity movementEntity= iMovementMapper
                .toMovementEntity(movementDto);
        movementEntity.setStatus(StatusEnum.P.name());
        return iMovementMapper
                .toMovementDto(iMovementCrudRepository
                        .save(movementEntity));
    }

    @Override
    public List<MovementDto> getAll() {
        return iMovementMapper.toMovementsDto(iMovementCrudRepository.findAll());
    }

    @Override
    public Optional<MovementDto> getMovementById(Long id) {
        return iMovementCrudRepository.findById(id)
                .map(iMovementMapper::toMovementDto);
    }

    @Override
    public List<MovementDto> getMovementByStatus(StatusEnum status) {
        return iMovementMapper.toMovementsDto(iMovementCrudRepository.findByStatus(status.name()));
    }

    @Override
    public MovementDto update(MovementDto modifyMovementDto) {
        return iMovementMapper
                .toMovementDto(iMovementCrudRepository
                        .save(iMovementMapper
                                .toMovementEntity(modifyMovementDto)));
    }

    @Override
    public void delete(Long id) {
        iMovementCrudRepository.deleteById(id);
    }
}
