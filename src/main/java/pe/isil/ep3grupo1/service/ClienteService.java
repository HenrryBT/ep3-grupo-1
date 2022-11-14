package pe.isil.ep3grupo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.ep3grupo1.repository.ClienteRepository;
import pe.isil.ep3grupo1.entity.Cliente;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public void add(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Transactional
    public void update(Cliente cliente, Long id) {
        Optional<Cliente> clienteToUpdate = clienteRepository.findById(id);

        if (clienteToUpdate.isPresent()) {
            clienteToUpdate.get().setNombres(cliente.getNombres() != null ? cliente.getNombres() : clienteToUpdate.get().getNombres());
            clienteToUpdate.get().setApellidos(cliente.getApellidos() != null ? cliente.getApellidos() : clienteToUpdate.get().getApellidos());
            clienteToUpdate.get().setEmail(cliente.getEmail() != null ? cliente.getEmail() : clienteToUpdate.get().getEmail());
            clienteToUpdate.get().setDireccion(cliente.getDireccion() != null ? cliente.getDireccion() : clienteToUpdate.get().getDireccion());
            clienteRepository.save(clienteToUpdate.get());
        } else {
            throw new RuntimeException("El Cliente no existe");
        }
    }

    public void delete(Long id) {
        Optional<Cliente> clienteToDelete = clienteRepository.findById(id);

        if (clienteToDelete.isPresent()) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente no existe");
        }
    }


    public Cliente buscarClientePorEmail(String email){
        return clienteRepository.findClienteByEmail(email);
    }
}
