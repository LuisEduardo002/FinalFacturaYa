package com.example.facturaya.dto;

import com.example.facturaya.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {
    private Long id;
    private String codigo;
    private String departamento;
    private int precio_venta;
    private Categoria categoria;
}
