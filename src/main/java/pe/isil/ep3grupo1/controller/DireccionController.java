package pe.isil.ep3grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.isil.ep3grupo1.entity.Direccion;
import pe.isil.ep3grupo1.service.DireccionService;

import java.util.List;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @PostMapping("/add")
    public void addDireccion(@RequestBody Direccion direccion){
        direccionService.add(direccion);
    }

    @PostMapping("/update")
    public void updateDireccion(@RequestBody Direccion direccion, @RequestParam Long id){
        direccionService.update(direccion,id);
    }

    @GetMapping({"/getall",""})
    public List<Direccion> getAllDireccion(){
        return direccionService.getAll();
    }

    @GetMapping("/getbyid")
    public Direccion getDireccionById(@RequestParam  Long id){
        return direccionService.getDireccionById(id);
    }

    @DeleteMapping("/delete")
    public void deleteDireccion(@RequestParam Long id){
        direccionService.delete(id);
    }
}
