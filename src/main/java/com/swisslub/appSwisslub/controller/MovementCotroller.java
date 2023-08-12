package com.swisslub.appSwisslub.controller;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.usecase.IMovementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/movements")
public class MovementCotroller {

    private final IMovementUseCase movementUseCase;
    @PostMapping(path = "/registerMovement")
    public ResponseEntity<ResponseMessageDto> save(@RequestBody MovementDto movementDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movementUseCase.save(movementDto));
    }
}
