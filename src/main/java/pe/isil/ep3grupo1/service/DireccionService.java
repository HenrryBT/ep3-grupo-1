package pe.isil.ep3grupo1.service;

import pe.isil.ep3grupo1.entity.Direccion;

import java.util.List;

public interface DireccionService {

    List<Direccion> getAllDirecciones();

    void addDireccion(Direccion direccion);

    void updateDireccion(Direccion direccion, Long id);

    void deleteDireccion(Long id);
}
