package com.institutoi3.indra_turorias.backend_tienda.repositorio;

import com.institutoi3.indra_turorias.backend_tienda.modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}