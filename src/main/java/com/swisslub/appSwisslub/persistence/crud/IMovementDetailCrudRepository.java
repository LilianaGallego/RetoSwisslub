package com.swisslub.appSwisslub.persistence.crud;

import com.swisslub.appSwisslub.persistence.entity.MovementDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovementDetailCrudRepository extends JpaRepository<MovementDetailEntity, Long> {
    List<MovementDetailEntity> findByMovementEntityStatus(String status);
    List<MovementDetailEntity> findByMovementEntityId(Long id);
}
