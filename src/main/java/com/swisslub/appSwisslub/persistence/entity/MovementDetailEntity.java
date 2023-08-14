package com.swisslub.appSwisslub.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "movement_detail")
@Entity
public class MovementDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movement_id")
    private MovementEntity movementEntity;
    @Column(length = 20)
    private String itemCode;
    private int quantitySent;
}
