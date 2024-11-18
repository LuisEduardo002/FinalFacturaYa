package com.example.facturaya.dto;

import com.example.facturaya.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImpuestoDto {
    private Long id;
    private String nombre;
    private BigDecimal porcentaje;
}
