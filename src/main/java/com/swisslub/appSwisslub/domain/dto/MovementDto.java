package com.swisslub.appSwisslub.domain.dto;

import com.swisslub.appSwisslub.enums.StatusEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovementDto {
    private Long id;
    private Long companyId;
    private String description;
    private String wineryOriginCode;
    private String wineryDestinationCode;
    private LocalDate creationDate;
    private LocalDate deliveryDate;
    private StatusEnum status;


}
