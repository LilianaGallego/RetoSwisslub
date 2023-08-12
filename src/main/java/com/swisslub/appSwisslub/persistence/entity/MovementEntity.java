package com.swisslub.appSwisslub.persistence.entity;

import com.swisslub.appSwisslub.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table(name = "movement")
@Entity
public class MovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long companyId;
    private String description;
    private String wineryOriginCode;
    private String wineryDestinationCode;
    private LocalDate creationDate;
    private LocalDate deliveryDate;
    private StatusEnum status;


}
