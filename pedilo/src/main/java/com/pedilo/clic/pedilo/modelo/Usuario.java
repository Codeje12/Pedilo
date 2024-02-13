package com.pedilo.clic.pedilo.modelo;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
@SequenceGenerator(name = "usuarioIdSeq",sequenceName = "usuario_id_sec",initialValue = 1,allocationSize = 1)
@Data
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usuarioIdSeq")
    private Long id;

    @Column
    private String mail;
    @Column
    private String clave;
    @Column
    private String usuario;
}