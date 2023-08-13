package com.swisslub.appSwisslub.controller;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.usecase.IMovementDetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/movementdetails")
public class MovementDetailController {
    private final IMovementDetailUseCase movementDetailUseCase;
    @PostMapping(path = "/register")
    public ResponseEntity<ResponseMessageDto> save(@RequestBody MovementDetailDto movementDetailDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movementDetailUseCase.save(movementDetailDto));
    }
}
