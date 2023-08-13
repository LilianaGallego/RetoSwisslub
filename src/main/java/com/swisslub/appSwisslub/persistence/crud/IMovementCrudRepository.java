package com.swisslub.appSwisslub.persistence.crud;

import com.swisslub.appSwisslub.persistence.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovementCrudRepository extends JpaRepository<MovementEntity, Long> {

    List<MovementEntity> findByStatus(String status);
}
