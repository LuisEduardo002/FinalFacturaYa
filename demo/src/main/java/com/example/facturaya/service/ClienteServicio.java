package com.example.facturaya.service;

import java.util.List;

import com.example.facturaya.dto.ClienteDto;

public interface ClienteServicio {
    ClienteDto crearCliente(ClienteDto clienteDto);

    ClienteDto getClienteById(long id);

    List<ClienteDto> getAllClientes();

    ClienteDto updateCliente(Long clienteId, ClienteDto updatedCliente);

    void eliminarCliente(long id);
}