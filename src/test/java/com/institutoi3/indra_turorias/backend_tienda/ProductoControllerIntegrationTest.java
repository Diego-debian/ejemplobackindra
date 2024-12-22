package com.institutoi3.indra_turorias.backend_tienda;

import com.institutoi3.indra_turorias.backend_tienda.repositorio.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductoControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void testObtenerProductos() {
        String url = "http://localhost:" + port + "/api/productos";
        String response = this.restTemplate.getForObject(url, String.class);
        assertThat(response).contains("Laptop");
    }
}