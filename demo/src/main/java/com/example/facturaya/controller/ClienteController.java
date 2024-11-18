package com.example.facturaya.controller;

import com.example.facturaya.dto.ClienteDto;
import com.example.facturaya.service.ClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private ClienteServicio ClienteServicio;

    @PostMapping
    //cosntruid anadir empleado REST API
    public ResponseEntity<ClienteDto> crearCliente(@RequestBody ClienteDto ClienteDto) {
        ClienteDto savedCliente =ClienteServicio.crearCliente(ClienteDto);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    //el get Cliente rest api
    @GetMapping("{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable("id") Long id) {
        ClienteDto ClienteDto = ClienteServicio.getClienteById(id);
        return ResponseEntity.ok(ClienteDto);
    }

    //crear getAll Clientes
    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        List<ClienteDto> Cliente =ClienteServicio.getAllClientes();
        return  ResponseEntity.ok(Cliente);
    }

    //actualizar Prodcucto
    @PutMapping("{id}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable ("id") Long id,@RequestBody ClienteDto updatedCliente) {
        ClienteDto ClienteDto =ClienteServicio.updateCliente(id, updatedCliente);
        return ResponseEntity.ok(ClienteDto);
    }

    //crear delete Cliente
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable("id") Long id) {
        ClienteServicio.eliminarCliente(id);
        return  ResponseEntity.ok("Cliente eliminado satisfactoriamente");
    }
}

