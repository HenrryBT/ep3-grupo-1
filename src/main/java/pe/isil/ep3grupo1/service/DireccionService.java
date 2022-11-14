package pe.isil.ep3grupo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.ep3grupo1.repository.DireccionRepository;
import pe.isil.ep3grupo1.entity.Direccion;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> getAll(){
        return direccionRepository.findAll();
    }

    public Direccion getDireccionById(Long id){
        return direccionRepository.findById(id).get();
    }
    public void add(Direccion direccion){
        direccionRepository.save(direccion);
    }

    @Transactional
    public void update(Direccion direccion, Long id){
        Optional<Direccion> DireaccionToUpdate = direccionRepository.findById(id);

        if(DireaccionToUpdate.isPresent()){
            DireaccionToUpdate.get().setDireaccion1(direccion.getDireaccion1()!=null? direccion.getDireaccion1() : DireaccionToUpdate.get().getDireaccion1());
            DireaccionToUpdate.get().setDireccion2(direccion.getDireccion2()!=null? direccion.getDireccion2() :DireaccionToUpdate.get().getDireccion2() );
            DireaccionToUpdate.get().setNroDireccion(direccion.getNroDireccion()!=null? direccion.getNroDireccion():DireaccionToUpdate.get().getNroDireccion());
            DireaccionToUpdate.get().setCiudad(direccion.getCiudad()!=null? direccion.getCiudad():DireaccionToUpdate.get().getCiudad());
            DireaccionToUpdate.get().setPais(direccion.getPais()!=null? direccion.getPais():DireaccionToUpdate.get().getPais());
            direccionRepository.save(DireaccionToUpdate.get());
        }else{
            throw new RuntimeException("Esta direccion no existe");
        }
    }

    public void delete(Long id){
        Optional<Direccion> direccionToDelete = direccionRepository.findById(id);

        if(direccionToDelete.isPresent()){
            direccionRepository.deleteById(id);
        }else{
            throw new RuntimeException("Esta direccion no existe");
        }
    }
}
