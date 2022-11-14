package pe.isil.ep3grupo1.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import pe.isil.ep3grupo1.entity.Ciudad;
import pe.isil.ep3grupo1.repository.CiudadRepository;
import pe.isil.ep3grupo1.service.CiudadService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class CiudadServiceImplementation implements CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> getAll() {
        return ciudadRepository.findAll();
    }

    public void add(Ciudad ciudad) {
        ciudadRepository.save(ciudad);
    }

    @Transactional
    public void update(Ciudad ciudad, Long id) {
        Optional<Ciudad> ciudadToUpdate = ciudadRepository.findById(id);

        if (ciudadToUpdate.isPresent()) {
            ciudadToUpdate.get().setDescripcion(ciudad.getDescripcion() != null ? ciudad.getDescripcion() : ciudadToUpdate.get().getDescripcion());
        } else {
            throw new RuntimeException("Esta Ciudad no existe");
        }
    }

    public void delete(Long id) {
        Optional<Ciudad> ciudadToDelete = ciudadRepository.findById(id);

        if (ciudadToDelete.isPresent()) {
            ciudadRepository.deleteById(id);
        } else {
            throw new RuntimeException("Esta Ciudad no existe");
        }
    }
}
