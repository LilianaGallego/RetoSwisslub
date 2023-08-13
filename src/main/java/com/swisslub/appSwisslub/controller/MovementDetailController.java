package com.swisslub.appSwisslub.controller;

import com.swisslub.appSwisslub.domain.dto.MovementDetailDto;
import com.swisslub.appSwisslub.domain.dto.ResponseMessageDto;
import com.swisslub.appSwisslub.domain.usecase.IMovementDetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<MovementDetailDto>> getAll() {
        return ResponseEntity.ok(movementDetailUseCase.getAll());
    }
    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<MovementDetailDto> update(@RequestBody MovementDetailDto movementDetailDtoUpdate, @PathVariable Long id) {
        return ResponseEntity.of(movementDetailUseCase.update(movementDetailDtoUpdate, id));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return movementDetailUseCase.delete(id);
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<MovementDetailDto> getById(@PathVariable Long id) {
        return ResponseEntity.of(movementDetailUseCase.getMovementDetailById(id));
    }
}
