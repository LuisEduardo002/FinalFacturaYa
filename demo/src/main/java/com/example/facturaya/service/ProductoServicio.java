package com.example.facturaya.service;

import com.example.facturaya.dto.ProductoDto;

import java.util.List;

public interface ProductoServicio {
    ProductoDto crearProducto(ProductoDto productoDto);

    ProductoDto getProductoById(long id);

    List<ProductoDto> getAllProductos();

    ProductoDto updateProducto(Long productoId, ProductoDto updatedProducto);

    void eliminarProducto(long id);
}
