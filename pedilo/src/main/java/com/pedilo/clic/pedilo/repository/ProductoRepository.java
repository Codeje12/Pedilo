package com.pedilo.clic.pedilo.repository;

import com.pedilo.clic.pedilo.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
