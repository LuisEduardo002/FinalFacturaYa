package com.example.facturaya.dto;

import com.example.facturaya.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    public Long id_numero_documento;
    public String nombre;
    public String direccion;
    public String telefono;
    public String email;
    public String cuidad;
    public String departamento;
}
