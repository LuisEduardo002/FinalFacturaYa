
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


    private ProductoRepository ProductoRepository;

    @Override
    public ProductoDto crearProducto(ProductoDto ProductoDto) {

        Producto Producto = ProductoMapper.mapToProducto(ProductoDto);
        Producto savedProducto = ProductoRepository.save(Producto);
        return ProductoMapper.mapToProductoDto(savedProducto);
    }

    @Override
    public ProductoDto getProductoById(long id) {
        Producto Producto =ProductoRepository.findById(id).orElseThrow(()->
                new ResouceNotFoundExcepcion("Producto no encontrado con el id" + id));
        return ProductoMapper.mapToProductoDto(Producto);
    }

    @Override
    public List<ProductoDto> getAllProductos() {
        List <Producto> Productos = ProductoRepository.findAll();
        return Productos.stream().map((Producto)-> ProductoMapper.mapToProductoDto(Producto)).collect(Collectors.toList());
    }

    @Override
    public ProductoDto updateProducto(Long idProducto, ProductoDto updatedProducto) {
        Producto Producto = ProductoRepository.findById(idProducto).orElseThrow(
                () -> new ResouceNotFoundExcepcion(idProducto + " no encontrado con el id" + idProducto)
        );

        Producto.setCodigo(updatedProducto.getCodigo());
        Producto.setDepartamento(updatedProducto.getDepartamento());
        Producto.setPrecio_venta(updatedProducto.getPrecio_venta());
        Producto.setCategoria(updatedProducto.getCategoria());
        Producto updatedProductoObj = ProductoRepository.save(Producto);
        return ProductoMapper.mapToProductoDto(updatedProductoObj);
    }


    @Override
    public void eliminarProducto(long id) {

        Producto Producto =ProductoRepository.findById(id).orElseThrow(
                ()->
                        new ResouceNotFoundExcepcion("Producto no encontrado con el id" + id));
        ProductoRepository.deleteById(id);
    }
}
