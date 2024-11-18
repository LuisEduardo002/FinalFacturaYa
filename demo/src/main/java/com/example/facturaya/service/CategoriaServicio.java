package com.example.facturaya.service;

import com.example.facturaya.dto.CategoriaDto;

import java.util.List;

public interface CategoriaServicio {
    CategoriaDto crearCategoria(CategoriaDto CategoriaDto);

    CategoriaDto getCategoriaById(long id);

    List<CategoriaDto> getAllCategorias();

    CategoriaDto updateCategoria(Long idCategoria, CategoriaDto updatedCategoria);

    void eliminarCategoria(long id);
}
