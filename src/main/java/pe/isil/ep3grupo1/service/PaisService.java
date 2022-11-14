package pe.isil.ep3grupo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.ep3grupo1.entity.Pais;
import pe.isil.ep3grupo1.repository.PaisRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> getAll() {
        return paisRepository.findAll();
    }

    public void add(Pais pais) {
        paisRepository.save(pais);
    }

    @Transactional
    public void update(Pais pais, Long id) {
        Optional<Pais> paisToUpdate = paisRepository.findById(id);

        if (paisToUpdate.isPresent()) {
            paisToUpdate.get().setDescripcion(pais.getDescripcion() != null ? pais.getDescripcion() : paisToUpdate.get().getDescripcion());
        } else {
            throw new RuntimeException("Este País no existe");
        }
    }

    public void delete(Long id) {
        Optional<Pais> paisToDelete = paisRepository.findById(id);

        if (paisToDelete.isPresent()) {
            paisRepository.deleteById(id);
        } else {
            throw new RuntimeException("Este País no existe");
        }
    }
}
