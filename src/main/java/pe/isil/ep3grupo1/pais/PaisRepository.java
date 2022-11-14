package pe.isil.ep3grupo1.pais;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais,Long> {
    Pais findPaisByDescripcion(String descripcion);
}
