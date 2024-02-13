package com.pedilo.clic.pedilo.modelo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tipo_unidad")
@SequenceGenerator(name = "tipoUnidadIdSeq",sequenceName = "tipo_unidad_id_sec",initialValue = 1,allocationSize = 1)
@Data
public class TipoUnidad {

    public static final Long UNIDAD = 1L;
    public static final Long KILOGRAMO = 2L;
    public static final Long LITRO = 3L;
    public static final Long DOCENA = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipoUnidadIdSeq")
    protected Long id;

    @Column
    private String nombre;
}
