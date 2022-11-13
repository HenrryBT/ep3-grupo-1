package pe.isil.ep3grupo1.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente findClienteByEmail(String email);
}
