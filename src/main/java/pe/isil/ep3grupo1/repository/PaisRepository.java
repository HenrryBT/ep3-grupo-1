package pe.isil.ep3grupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.ep3grupo1.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    Pais findPaisByDescripcion(String descripcion);
}