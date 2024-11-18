package com.example.facturaya.controller;

import com.example.facturaya.dto.CategoriaDto;
import com.example.facturaya.service.CategoriaServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/categoria")


public class CategoriaController {

    private CategoriaServicio CategoriaService;

    @PostMapping
    //cosntruid anadir empleado REST API
    public ResponseEntity<CategoriaDto> crearCategoria(@RequestBody CategoriaDto CategoriaDto) {
        CategoriaDto savedCategoria =CategoriaService.crearCategoria(CategoriaDto);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    //el get Categoria rest api
    @GetMapping("{id}")
    public ResponseEntity<CategoriaDto> getCategoriaById(@PathVariable("id") Long id) {
        CategoriaDto CategoriaDto = CategoriaService.getCategoriaById(id);
        return ResponseEntity.ok(CategoriaDto);
    }

    //crear getAll Categorias
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAllCategorias() {
        List<CategoriaDto> Categoria =CategoriaService.getAllCategorias();
        return  ResponseEntity.ok(Categoria);
    }

    //actualizar Prodcucto
    @PutMapping("{id}")
    public ResponseEntity<CategoriaDto> updateCategoria(@PathVariable ("id") Long id,@RequestBody CategoriaDto updatedCategoria) {
        CategoriaDto CategoriaDto =CategoriaService.updateCategoria(id, updatedCategoria);
        return ResponseEntity.ok(CategoriaDto);
    }

    //crear delete Categoria
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable("id") Long id) {
        CategoriaService.eliminarCategoria(id);
        return  ResponseEntity.ok("Categoria eliminado satisfactoriamente");
    }

}
