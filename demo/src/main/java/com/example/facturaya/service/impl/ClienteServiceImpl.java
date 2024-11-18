
package com.example.facturaya.service.impl;

import com.example.facturaya.dto.ClienteDto;
import com.example.facturaya.entity.Cliente;
import com.example.facturaya.exception.ResouceNotFoundExcepcion;
import com.example.facturaya.mapper.ClienteMapper;
import com.example.facturaya.repository.ClienteRepository;
import com.example.facturaya.service.ClienteServicio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteServicio {

    private ClienteRepository ClienteRepository;

    @Override
    public ClienteDto crearCliente(ClienteDto ClienteDto) {

        Cliente Cliente = ClienteMapper.mapToCliente(ClienteDto);
        Cliente savedCliente = ClienteRepository.save(Cliente);
        return ClienteMapper.mapToClienteDto(savedCliente);
    }

    @Override
    public ClienteDto getClienteById(long id) {
        Cliente Cliente =ClienteRepository.findById(id).orElseThrow(()->
                new ResouceNotFoundExcepcion("Cliente no encontrado con el id" + id));
        return ClienteMapper.mapToClienteDto(Cliente);
    }

    @Override
    public List<ClienteDto> getAllClientes() {
        List <Cliente> Clientes = ClienteRepository.findAll();
        return Clientes.stream().map((Cliente)-> ClienteMapper.mapToClienteDto(Cliente)).collect(Collectors.toList());
    }

    @Override
    public ClienteDto updateCliente(Long idCliente, ClienteDto updatedCliente) {
        Cliente cliente = ClienteRepository.findById(idCliente).orElseThrow(
                () -> new ResouceNotFoundExcepcion(idCliente + " no encontrado con el id" + idCliente)
        );


        cliente.setId_numero_documento(updatedCliente.getId_numero_documento());
        cliente.setNombre(updatedCliente.getNombre());
        cliente.setDireccion(updatedCliente.getDireccion());
        cliente.setTelefono(updatedCliente.getTelefono());
        cliente.setEmail(updatedCliente.getEmail());
        cliente.setCuidad(updatedCliente.getCuidad());
        cliente.setDepartamento(updatedCliente.getDepartamento());
        Cliente updatedClienteObj = ClienteRepository.save(cliente);
        return ClienteMapper.mapToClienteDto(updatedClienteObj);
    }


    @Override
    public void eliminarCliente(long id) {

        Cliente Cliente =ClienteRepository.findById(id).orElseThrow(
                ()->
                        new ResouceNotFoundExcepcion("Cliente no encontrado con el id" + id));
        ClienteRepository.deleteById(id);
    }
}
