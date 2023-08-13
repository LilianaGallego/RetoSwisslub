package com.swisslub.appSwisslub.persistence.repository;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.repository.IMovementDetailRepository;
import com.swisslub.appSwisslub.enums.StatusEnum;
import com.swisslub.appSwisslub.persistence.crud.IMovementDetailCrudRepository;
import com.swisslub.appSwisslub.persistence.mapper.IMovementDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MovementDetailRepository implements IMovementDetailRepository {
    private final IMovementDetailCrudRepository iMovementDetailCrudRepository;
    private final IMovementDetailMapper iMovementDetailMapper;
    @Override
    public MovementDetailDto save(MovementDetailDto movementDetailDto) {
        return iMovementDetailMapper
                .toMovementDetailDto(iMovementDetailCrudRepository.save(iMovementDetailMapper
                        .toMovementDetailEntity(movementDetailDto)));
    }

    @Override
    public List<MovementDetailDto> getAll() {
        return null;
    }

    @Override
    public Optional<MovementDetailDto> getMovementDetailById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<MovementDetailDto> getByStatus(StatusEnum status) {
        return null;
    }

    @Override
    public MovementDetailDto update(MovementDetailDto modifyMovementDetailDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
