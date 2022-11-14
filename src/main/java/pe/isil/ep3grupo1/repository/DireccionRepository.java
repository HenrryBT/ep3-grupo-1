package pe.isil.ep3grupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.ep3grupo1.entity.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
