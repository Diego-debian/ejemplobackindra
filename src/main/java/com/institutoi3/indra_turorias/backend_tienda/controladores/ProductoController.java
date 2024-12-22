package com.institutoi3.indra_turorias.backend_tienda.controladores;

import com.institutoi3.indra_turorias.backend_tienda.modelos.Producto;
import com.institutoi3.indra_turorias.backend_tienda.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        if (productoService.existePorNombre(producto.getNombre())) {
            throw new RuntimeException("Producto con el mismo nombre ya existe");
        }
        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        return productoService.actualizar(id, productoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
