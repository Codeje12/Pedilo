package com.pedilo.clic.pedilo.repository;

import com.pedilo.clic.pedilo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
