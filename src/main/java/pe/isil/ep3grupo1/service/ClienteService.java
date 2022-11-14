package pe.isil.ep3grupo1.service;

import pe.isil.ep3grupo1.entity.Cliente;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllClientes();
    void addClientes(Cliente cliente);
    void updateCliente(Cliente cliente, Long id);
    void deleteCliente(Long id);
    Cliente getClientesByEmail(String email);
}
