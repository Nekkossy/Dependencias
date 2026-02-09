package es.iesquevedo.servicios;

import es.iesquevedo.dao.*;
import es.iesquevedo.modelo.Alquiler;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlquilerServiceTest {

    @Test
    void listarAlquileres_test() {

        String base = "src/test/resources";

        PeliculaDao peliculaDao =
                new JsonPeliculaDao(base + "/peliculas_test.json");

        SocioDao socioDao =
                new JsonSocioDao(base + "/socios_test.json");

        AlquilerDao alquilerDao =
                new JsonAlquilerDao(base + "/alquileres_test.json");

        AlquilerService service =
                new AlquilerService(peliculaDao, socioDao, alquilerDao, 3);

        List<Alquiler> alquileres = service.listarAlquileres();

        assertNotNull(alquileres);
        assertFalse(alquileres.isEmpty());
    }
}