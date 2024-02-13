package com.pedilo.clic.pedilo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Type;
import java.math.BigDecimal;

@Entity
@Table(name="producto")
@SequenceGenerator(name = "productoIdSeq",sequenceName = "producto_id_sec",initialValue = 1,allocationSize = 1)
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "productoIdSeq")
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_unidad", nullable = false)
    private TipoUnidad tipoUnidad;

    @Column
    private Boolean activo;

    @Column
    private String nombre;

    @Column
    private BigDecimal precio;

    @Column
    private String imagen;

    @Column
    private String descripcion;
}
