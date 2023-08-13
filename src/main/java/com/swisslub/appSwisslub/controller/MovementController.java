package com.swisslub.appSwisslub.controller;

import com.swisslub.appSwisslub.domain.dto.MovementDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.usecase.IMovementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/movements")
public class MovementController {

    private final IMovementUseCase movementUseCase;
    @PostMapping(path = "/registerMovement")
    public ResponseEntity<ResponseMessageDto> save(@RequestBody MovementDto movementDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movementUseCase.save(movementDto));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<MovementDto>> getAll() {
        return ResponseEntity.ok(movementUseCase.getAll());
    }
}
