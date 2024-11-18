package com.example.facturaya.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facturaya.dto.ImpuestoDto;
import com.example.facturaya.service.ImpuestoServicio;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/impuesto")
public class ImpuestoController {
    private ImpuestoServicio ImpuestoServicio;

    @PostMapping
    //cosntruid anadir empleado REST API
    public ResponseEntity<ImpuestoDto> crearImpuesto(@RequestBody ImpuestoDto ImpuestoDto) {
        ImpuestoDto savedImpuesto =ImpuestoServicio.crearImpuesto(ImpuestoDto);
        return new ResponseEntity<>(savedImpuesto, HttpStatus.CREATED);
    }

    //el get Impuesto rest api
    @GetMapping("{id}")
    public ResponseEntity<ImpuestoDto> getImpuestoById(@PathVariable("id") Long id) {
        ImpuestoDto ImpuestoDto = ImpuestoServicio.getImpuestoById(id);
        return ResponseEntity.ok(ImpuestoDto);
    }

    //crear getAll Impuestos
    @GetMapping
    public ResponseEntity<List<ImpuestoDto>> getAllImpuestos() {
        List<ImpuestoDto> Impuesto =ImpuestoServicio.getAllImpuestos();
        return  ResponseEntity.ok(Impuesto);
    }

    //actualizar Prodcucto
    @PutMapping("{id}")
    public ResponseEntity<ImpuestoDto> updateImpuesto(@PathVariable ("id") Long id,@RequestBody ImpuestoDto updatedImpuesto) {
        ImpuestoDto ImpuestoDto =ImpuestoServicio.updateImpuesto(id, updatedImpuesto);
        return ResponseEntity.ok(ImpuestoDto);
    }

    //crear delete Impuesto
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteImpuesto(@PathVariable("id") Long id) {
        ImpuestoServicio.eliminarImpuesto(id);
        return  ResponseEntity.ok("Impuesto eliminado satisfactoriamente");
    }
}
