package com.example.facturaya.mapper;

import com.example.facturaya.dto.ClienteDto;
import com.example.facturaya.dto.ClienteDto;
import com.example.facturaya.entity.Cliente;


public class ClienteMapper {
    public static ClienteDto mapToClienteDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getId_numero_documento(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getCuidad(),
                cliente.getDepartamento()
        );
    }
    public static Cliente mapToCliente(ClienteDto clienteDto) {
        return new Cliente(
                clienteDto.getId_numero_documento(),
                clienteDto.getNombre(),
                clienteDto.getDireccion(),
                clienteDto.getTelefono(),
                clienteDto.getEmail(),
                clienteDto.getCuidad(),
                clienteDto.getDepartamento()
        );
    }
}
