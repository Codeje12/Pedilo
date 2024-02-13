package com.pedilo.clic.pedilo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="usuario_vendedor")
@SequenceGenerator(name = "usuarioVendedorIdSeq",sequenceName = "usuario_vendedor_id_sec",initialValue = 1,allocationSize = 1)
@Data
public class UsuarioVendedor extends Usuario{

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    protected Long id;

    @Column(name="nombre")
    private String nombre;
}
