package com.institutoi3.indra_turorias.backend_tienda.repositorio;

import com.institutoi3.indra_turorias.backend_tienda.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    boolean existsByNombre(String nombre);
}