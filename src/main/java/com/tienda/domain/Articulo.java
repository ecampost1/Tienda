package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArticulo") 
    private Long idArticulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "existencias")
    private int existencias;

    @Column(name = "precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "id_categoria") // coincide con el FK en la tabla articulo
    private Categoria categoria;
}