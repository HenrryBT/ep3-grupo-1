package pe.isil.ep3grupo1.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PaisService {
    @Autowired
    private  PaisRepository paisRepository;

    public List<Pais> getAll(){
        return paisRepository.findAll();
    }
    public Pais getPaisById(Long id){
        return paisRepository.findById(id).get();
    }

    public Pais getPaisByName(String name){
        return paisRepository.findPaisByDescripcion(name);
    }

    public void add(Pais pais){
        paisRepository.save(pais);
    }

    @Transactional
    public void update(Pais pais, Long id){

        Optional<Pais> paisToUpdate = paisRepository.findById(id);

        if(paisToUpdate.isPresent()){

            paisToUpdate.get().setDescripcion(pais.getDescripcion()!=null? pais.getDescripcion() : paisToUpdate.get().getDescripcion());


        }else{
            throw new RuntimeException("Pais does not exist");
        }
    }

    public void delete(Long id){
        Optional<Pais> paisToDelete = paisRepository.findById(id);
        if(paisToDelete.isPresent()){
            paisRepository.delete(paisToDelete.get());
        }else{
            throw new RuntimeException("Item does not exist");
        }
    }
}
