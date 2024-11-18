package com.example.facturaya.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "cliente")
public class Cliente {

    @Id
    private Long id_numero_documento;

    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @Column(name = "telefono", length = 255, nullable = false)
    private String telefono;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "cuidad", length = 255, nullable = false)
    private String cuidad;

    @Column(name = "departamento", length = 255, nullable = false)
    private String departamento;


}
