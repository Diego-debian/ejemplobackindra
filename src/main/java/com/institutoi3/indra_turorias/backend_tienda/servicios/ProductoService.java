package com.institutoi3.indra_turorias.backend_tienda.servicios;

import com.institutoi3.indra_turorias.backend_tienda.modelos.Producto;
import com.institutoi3.indra_turorias.backend_tienda.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setStock(productoActualizado.getStock());
        producto.setCategoria(productoActualizado.getCategoria());

        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public boolean existePorNombre(String nombre) {
        return productoRepository.existsByNombre(nombre);
    }
}