package com.example.facturaya.controller;

import com.example.facturaya.dto.ProductoDto;
import com.example.facturaya.service.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private ProductoServicio productoServicio;

    @PostMapping
    //cosntruid anadir empleado REST API
    public ResponseEntity<ProductoDto> crearProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto savedProducto =productoServicio.crearProducto(productoDto);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

    //el get producto rest api
    @GetMapping("{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable("id") Long id) {
        ProductoDto productoDto = productoServicio.getProductoById(id);
        return ResponseEntity.ok(productoDto);
    }

    //crear getAll productos
    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllProductos() {
        List<ProductoDto> producto =productoServicio.getAllProductos();
        return  ResponseEntity.ok(producto);
    }

    //actualizar Prodcucto
    @PutMapping("{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable ("id") Long id,@RequestBody ProductoDto updatedProducto) {
        ProductoDto productoDto =productoServicio.updateProducto(id, updatedProducto);
        return ResponseEntity.ok(productoDto);
    }

    //crear delete producto
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable("id") Long id) {
        productoServicio.eliminarProducto(id);
        return  ResponseEntity.ok("Producto eliminado satisfactoriamente");
    }
}
