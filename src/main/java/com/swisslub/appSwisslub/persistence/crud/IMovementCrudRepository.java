package com.swisslub.appSwisslub.persistence.crud;


import com.swisslub.appSwisslub.enums.StatusEnum;
import com.swisslub.appSwisslub.persistence.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMovementCrudRepository extends JpaRepository<MovementEntity, Long> {

    Optional<MovementEntity> findByStatus(StatusEnum status);
}
