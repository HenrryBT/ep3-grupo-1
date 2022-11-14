package pe.isil.ep3grupo1.service;

import pe.isil.ep3grupo1.entity.Pais;

import java.util.List;

public interface PaisService {
    void add(Pais pais);
    void update(Pais pais, Long id);
    void delete(Long id);
    List<Pais> getAll();
}
