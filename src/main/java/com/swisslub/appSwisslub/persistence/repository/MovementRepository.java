package com.swisslub.appSwisslub.persistence.repository;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.repository.IMovementRepository;
import com.swisslub.appSwisslub.enums.StatusEnum;
import com.swisslub.appSwisslub.persistence.crud.IMovementCrudRepository;
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
        return iMovementMapper
                .toMovementDto(iMovementCrudRepository
                        .save(iMovementMapper
                                .toMovementEntity(movementDto)));
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
    public Optional<MovementDto> getMovementByStatus(StatusEnum status) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        iMovementCrudRepository.deleteById(id);
    }
}
