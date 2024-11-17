package com.example.facturaya.mapper;

import com.example.facturaya.dto.ProductoDto;
import com.example.facturaya.entity.Producto;

public class ProductoMapper {
    public static ProductoDto mapToProductoDto(Producto producto) {
        return new ProductoDto(
                producto.getId(),
                producto.getCodigo(),
                producto.getDepartamento(),
                producto.getPrecio_venta(),
                producto.getCategoria()
        );
    }
    public static Producto mapToProducto(ProductoDto productoDto) {
        return new Producto(
                productoDto.getId(),
                productoDto.getCodigo(),
                productoDto.getDepartamento(),
                productoDto.getPrecio_venta(),
                productoDto.getCategoria()
        );
    }
}
