package com.example.facturaya.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @OneToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria ;
}
