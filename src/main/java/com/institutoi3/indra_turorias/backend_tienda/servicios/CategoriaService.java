package com.institutoi3.indra_turorias.backend_tienda.servicios;

import com.institutoi3.indra_turorias.backend_tienda.modelos.Categoria;
import com.institutoi3.indra_turorias.backend_tienda.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}