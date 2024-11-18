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
public class CategoriaDto {
    private Long idCategoria;
    private String descripcion;

}
