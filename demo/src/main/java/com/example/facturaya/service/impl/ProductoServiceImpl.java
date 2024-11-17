package com.example.facturaya.service.impl;

import com.example.facturaya.dto.ProductoDto;
import com.example.facturaya.entity.Producto;
import com.example.facturaya.exception.ResouceNotFoundExcepcion;
import com.example.facturaya.mapper.ProductoMapper;
import com.example.facturaya.repository.ProductoRepository;
import com.example.facturaya.service.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoServicio {

        private ProductoRepository productoRepository;
    @Override
    public ProductoDto crearProducto(ProductoDto productoDto) {

        Producto producto = ProductoMapper.mapToProducto(productoDto);
        Producto savedProducto = productoRepository.save(producto);
        return ProductoMapper.mapToProductoDto(savedProducto);
    }

    @Override
    public ProductoDto getProductoById(long id) {
        Producto producto =productoRepository.findById(id).orElseThrow(()->
                new ResouceNotFoundExcepcion("Producto no encontrado con el id" + id));
        return ProductoMapper.mapToProductoDto(producto);
    }

    @Override
    public List<ProductoDto> getAllProductos() {
        List <Producto> productos = productoRepository.findAll();
        return productos.stream().map((producto)-> ProductoMapper.mapToProductoDto(producto)).collect(Collectors.toList());
    }

    @Override
    public ProductoDto updateProducto(Long productoId, ProductoDto updatedProducto) {

        Producto producto = productoRepository.findById(productoId).orElseThrow(
                () -> new ResouceNotFoundExcepcion(productoId + " no encontrado con el id" + productoId)
        );
        producto.setCategoria(updatedProducto.getCategoria());
        producto.setCategoria(updatedProducto.getCategoria());
        producto.setPrecio_venta(updatedProducto.getPrecio_venta());
        producto.setDepartamento(updatedProducto.getDepartamento());
        producto.setCodigo(updatedProducto.getCodigo());
        Producto updatedProductoObj = productoRepository.save(producto);
        return ProductoMapper.mapToProductoDto(updatedProductoObj);
    }

    @Override
    public void eliminarProducto(long id) {

        Producto producto =productoRepository.findById(id).orElseThrow(
                ()->
                new ResouceNotFoundExcepcion("Producto no encontrado con el id" + id));
        productoRepository.deleteById(id);
    }
}
