package com.pedilo.clic.pedilo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="configuracion")
@SequenceGenerator(name = "configuracionIdSeq",sequenceName = "configuracion_id_sec",initialValue = 1,allocationSize = 1)
@Data
public class Configuracion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "configuracionIdSeq")
    protected Long id;

    @Column(name = "nombre_emprendimiento")
    private String nombreEmprendimiento;
    @Column(name = "ubicacion")
    private String linkUbicacion;
    @Column(name = "numero_telefono")
    private String whatsApp;

/*    @ManyToOne
    @JoinColumn(name = "id_usuario_vendedor")
    private UsuarioVendedor usuarioVendedor;*/
}
