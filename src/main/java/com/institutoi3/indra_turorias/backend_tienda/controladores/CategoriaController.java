package com.institutoi3.indra_turorias.backend_tienda.controladores;

import com.institutoi3.indra_turorias.backend_tienda.modelos.Categoria;
import com.institutoi3.indra_turorias.backend_tienda.servicios.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerTodas() {
        return categoriaService.obtenerTodas();
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
    }
}
