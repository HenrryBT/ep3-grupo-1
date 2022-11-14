package pe.isil.ep3grupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.ep3grupo1.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente findClienteByEmail(String email);
}
