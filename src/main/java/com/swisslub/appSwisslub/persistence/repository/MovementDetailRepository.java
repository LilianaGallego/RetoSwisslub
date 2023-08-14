package com.swisslub.appSwisslub.persistence.repository;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMovementDetailDto;
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
        return iMovementDetailMapper.toMovementDetailsDto(iMovementDetailCrudRepository.findAll());
    }

    @Override
    public Optional<MovementDetailDto> getMovementDetailById(Long id) {
        return iMovementDetailCrudRepository.findById(id)
                .map(iMovementDetailMapper::toMovementDetailDto);
    }

    @Override
    public List<MovementDetailDto> getByStatus(StatusEnum status) {
        return iMovementDetailMapper.toMovementDetailsDto(iMovementDetailCrudRepository
                .findByMovementEntityStatus(status.toString()));
    }

    @Override
    public List<ResponseMovementDetailDto> getResponseByStatus(StatusEnum status) {
        return iMovementDetailMapper.toResponseMovementDetailDtoList(iMovementDetailCrudRepository
                .findByMovementEntityStatus(status.toString()));
    }

    @Override
    public MovementDetailDto update(MovementDetailDto modifyMovementDetailDto) {
        return iMovementDetailMapper.toMovementDetailDto((iMovementDetailCrudRepository
                .save(iMovementDetailMapper
                        .toMovementDetailEntity(modifyMovementDetailDto))));
    }

    @Override
    public void delete(Long id) {
        iMovementDetailCrudRepository.deleteById(id);
    }

    @Override
    public List<MovementDetailDto> getByMovementId(Long id) {
        return iMovementDetailMapper.toMovementDetailsDto(iMovementDetailCrudRepository
                .findByMovementEntityId(id));
    }
}
