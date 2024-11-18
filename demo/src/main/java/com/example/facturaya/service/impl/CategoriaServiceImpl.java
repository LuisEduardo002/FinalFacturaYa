package com.example.facturaya.service.impl;

import com.example.facturaya.dto.CategoriaDto;
import com.example.facturaya.entity.Categoria;
import com.example.facturaya.exception.ResouceNotFoundExcepcion;
import com.example.facturaya.mapper.CategoriaMapper;
import com.example.facturaya.repository.CategoriaRepository;
import com.example.facturaya.service.CategoriaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaServicio{

    private CategoriaRepository CategoriaRepository;

    @Override
    public CategoriaDto crearCategoria(CategoriaDto CategoriaDto) {

        Categoria Categoria = CategoriaMapper.mapToCategoria(CategoriaDto);
        Categoria savedCategoria = CategoriaRepository.save(Categoria);
        return CategoriaMapper.mapToCategoriaDto(savedCategoria);
    }

    @Override
    public CategoriaDto getCategoriaById(long id) {
        Categoria Categoria =CategoriaRepository.findById(id).orElseThrow(()->
                new ResouceNotFoundExcepcion("Categoria no encontrado con el id" + id));
        return CategoriaMapper.mapToCategoriaDto(Categoria);
    }

    @Override
    public List<CategoriaDto> getAllCategorias() {
        List <Categoria> Categorias = CategoriaRepository.findAll();
        return Categorias.stream().map((Categoria)-> CategoriaMapper.mapToCategoriaDto(Categoria)).collect(Collectors.toList());
    }

    @Override
    public CategoriaDto updateCategoria(Long idCategoria, CategoriaDto updatedCategoria) {
        Categoria Categoria = CategoriaRepository.findById(idCategoria).orElseThrow(
                () -> new ResouceNotFoundExcepcion(idCategoria + " no encontrado con el id" + idCategoria)
        );
        Categoria.setIdCategoria(updatedCategoria.getIdCategoria());
        Categoria.setDescripcion(updatedCategoria.getDescripcion());
        Categoria updatedCategoriaObj = CategoriaRepository.save(Categoria);
        return CategoriaMapper.mapToCategoriaDto(updatedCategoriaObj);
    }


    @Override
    public void eliminarCategoria(long id) {

        Categoria Categoria =CategoriaRepository.findById(id).orElseThrow(
                ()->
                        new ResouceNotFoundExcepcion("Categoria no encontrado con el id" + id));
        CategoriaRepository.deleteById(id);
    }

}
