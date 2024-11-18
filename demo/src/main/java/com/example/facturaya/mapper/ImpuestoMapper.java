package com.example.facturaya.mapper;

import com.example.facturaya.dto.ImpuestoDto;
import com.example.facturaya.dto.ImpuestoDto;
import com.example.facturaya.entity.Impuesto;


public class ImpuestoMapper {
    public static ImpuestoDto mapToImpuestoDto(Impuesto impuesto) {
        return new ImpuestoDto(

                impuesto.getId(),
                impuesto.getNombre(),
                impuesto.getPorcentaje()
        );
    }
    public static Impuesto mapToImpuesto(ImpuestoDto ImpuestoDto) {
        return new Impuesto(
                ImpuestoDto.getId(),
                ImpuestoDto.getNombre(),
                ImpuestoDto.getPorcentaje()
        );
    }
}
