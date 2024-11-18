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
@Table (name = "producto")
public class Producto {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "departamento", length = 255, nullable = false)
    private String departamento;

    @Column(name = "precio_venta")
    private int precio_venta;

    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria ;
}
