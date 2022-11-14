package pe.isil.ep3grupo1.ciudad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;
    public List<Ciudad> getAll() {return ciudadRepository.findAll();};
    public Ciudad getCiudadById(Long id){return ciudadRepository.findById(id).get();}
    public Ciudad getCiudadByDescripcion(String description){return ciudadRepository.findByDescripcion(description);}
    public void add(Ciudad ciudad){ciudadRepository.save(ciudad);}
    @Transactional
    public void update(Ciudad ciudad, Long id){
        Optional<Ciudad> ciudadToUpdate = ciudadRepository.findById(id);
        if (ciudadToUpdate.isPresent()){
            ciudadToUpdate.get().setDescripcion(ciudad.getDescripcion()!=null? ciudad.getDescripcion() : ciudadToUpdate.get().getDescripcion());
        }else {
            throw new RuntimeException("Ciudad no existe");
        }

    }

    public void delete(Long id){
        Optional<Ciudad> ciudadToDelete = ciudadRepository.findById(id);
        if (ciudadToDelete.isPresent()){
            ciudadRepository.delete(ciudadToDelete.get());
        }else{
            throw new RuntimeException("Ciudad no existe");
        }
    }
}
