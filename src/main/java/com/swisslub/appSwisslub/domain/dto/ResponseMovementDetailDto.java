package com.swisslub.appSwisslub.domain.dto;

import lombok.Data;

@Data
public class ResponseMovementDetailDto {
    private Long id;
    private Long movementId;
    private Long companyId;
    private String wineryOriginCode;
    private String wineryDestinationCode;
    private String itemCode;


}
