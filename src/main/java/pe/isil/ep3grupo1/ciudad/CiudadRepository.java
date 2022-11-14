package pe.isil.ep3grupo1.ciudad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad,Long> {
    Ciudad findByDescripcion(String descrption);
}
