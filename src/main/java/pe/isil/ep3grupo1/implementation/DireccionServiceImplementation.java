package pe.isil.ep3grupo1.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.ep3grupo1.entity.Direccion;
import pe.isil.ep3grupo1.repository.DireccionRepository;
import pe.isil.ep3grupo1.service.DireccionService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImplementation implements DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> getAllDirecciones() {
        return direccionRepository.findAll();
    }

    public void addDireccion(Direccion direccion) {
        direccionRepository.save(direccion);
    }

    @Transactional
    public void updateDireccion(Direccion direccion, Long id) {
        Optional<Direccion> DireaccionToUpdate = direccionRepository.findById(id);

        if (DireaccionToUpdate.isPresent()) {
            DireaccionToUpdate.get().setDireccion1(direccion.getDireccion1() != null ? direccion.getDireccion1() : DireaccionToUpdate.get().getDireccion1());
            DireaccionToUpdate.get().setDireccion2(direccion.getDireccion2() != null ? direccion.getDireccion2() : DireaccionToUpdate.get().getDireccion2());
            DireaccionToUpdate.get().setNroDireccion(direccion.getNroDireccion() != null ? direccion.getNroDireccion() : DireaccionToUpdate.get().getNroDireccion());
            direccionRepository.save(DireaccionToUpdate.get());
        } else {
            throw new RuntimeException("Esta direccion no existe");
        }
    }

    public void deleteDireccion(Long id) {
        Optional<Direccion> direccionToDelete = direccionRepository.findById(id);

        if (direccionToDelete.isPresent()) {
            direccionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Esta direccion no existe");
        }
    }
}
