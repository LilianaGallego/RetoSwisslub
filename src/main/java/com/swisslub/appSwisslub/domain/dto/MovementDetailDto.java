package com.swisslub.appSwisslub.domain.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MovementDetailDto {
    private Long id;
    private Long movementId;
    @Column(length = 20)
    private String itemCode;
    private int quantitySent;
}
