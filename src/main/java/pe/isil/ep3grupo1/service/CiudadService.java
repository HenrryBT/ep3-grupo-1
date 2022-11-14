package pe.isil.ep3grupo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import pe.isil.ep3grupo1.entity.Ciudad;
import pe.isil.ep3grupo1.repository.CiudadRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CiudadService {

    public List<Ciudad> getAll();
    public void add(Ciudad ciudad);
    public void update(Ciudad ciudad, Long id);
    public void delete(Long id);
}
