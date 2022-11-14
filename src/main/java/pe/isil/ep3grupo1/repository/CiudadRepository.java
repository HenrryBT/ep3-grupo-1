package pe.isil.ep3grupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.ep3grupo1.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad,Long> {
}
