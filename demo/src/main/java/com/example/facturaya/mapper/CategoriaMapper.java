package com.example.facturaya.mapper;

import com.example.facturaya.dto.CategoriaDto;
import com.example.facturaya.entity.Categoria;

public class CategoriaMapper {
    public static CategoriaDto mapToCategoriaDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.getIdCategoria(),
                categoria.getDescripcion()
        );
    }
    public static Categoria mapToCategoria(CategoriaDto categoriaDto) {
        return new Categoria(
                categoriaDto.getIdCategoria(),
                categoriaDto.getDescripcion()
        );
    }


}
