
package com.example.facturaya.service.impl;

import com.example.facturaya.dto.ImpuestoDto;
import com.example.facturaya.entity.Impuesto;
import com.example.facturaya.exception.ResouceNotFoundExcepcion;
import com.example.facturaya.mapper.ImpuestoMapper;
import com.example.facturaya.repository.ImpuestoRepository;
import com.example.facturaya.service.ImpuestoServicio;

import com.example.facturaya.service.ImpuestoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImpuestoImpl implements ImpuestoServicio {

    private ImpuestoRepository ImpuestoRepository;

    @Override
    public ImpuestoDto crearImpuesto(ImpuestoDto ImpuestoDto) {

        Impuesto Impuesto = ImpuestoMapper.mapToImpuesto(ImpuestoDto);
        Impuesto savedImpuesto = ImpuestoRepository.save(Impuesto);
        return ImpuestoMapper.mapToImpuestoDto(savedImpuesto);
    }

    @Override
    public ImpuestoDto getImpuestoById(long id) {
        Impuesto Impuesto =ImpuestoRepository.findById(id).orElseThrow(()->
                new ResouceNotFoundExcepcion("Impuesto no encontrado con el id" + id));
        return ImpuestoMapper.mapToImpuestoDto(Impuesto);
    }

    @Override
    public List<ImpuestoDto> getAllImpuestos() {
        List <Impuesto> Impuestos = ImpuestoRepository.findAll();
        return Impuestos.stream().map((Impuesto)-> ImpuestoMapper.mapToImpuestoDto(Impuesto)).collect(Collectors.toList());
    }

    @Override
    public ImpuestoDto updateImpuesto(Long idImpuesto, ImpuestoDto updatedImpuesto) {
        Impuesto Impuesto = ImpuestoRepository.findById(idImpuesto).orElseThrow(
                () -> new ResouceNotFoundExcepcion(idImpuesto + " no encontrado con el id" + idImpuesto)
        );

        Impuesto.setId(updatedImpuesto.getId());
        Impuesto.setNombre(updatedImpuesto.getNombre());
        Impuesto.setPorcentaje(updatedImpuesto.getPorcentaje());
        Impuesto updatedImpuestoObj = ImpuestoRepository.save(Impuesto);
        return ImpuestoMapper.mapToImpuestoDto(updatedImpuestoObj);
    }


    @Override
    public void eliminarImpuesto(long id) {

        Impuesto Impuesto =ImpuestoRepository.findById(id).orElseThrow(
                ()->
                        new ResouceNotFoundExcepcion("Impuesto no encontrado con el id" + id));
        ImpuestoRepository.deleteById(id);
    }
}

