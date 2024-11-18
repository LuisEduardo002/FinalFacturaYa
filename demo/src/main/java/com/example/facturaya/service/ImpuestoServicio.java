package com.example.facturaya.service;

import com.example.facturaya.dto.ImpuestoDto;

import java.util.List;

public interface ImpuestoServicio {
    ImpuestoDto crearImpuesto(ImpuestoDto ImpuestoDto);

    ImpuestoDto getImpuestoById(long id);

    List<ImpuestoDto> getAllImpuestos();

    ImpuestoDto updateImpuesto(Long ImpuestoId, ImpuestoDto updatedImpuesto);

    void eliminarImpuesto(long id);
}
