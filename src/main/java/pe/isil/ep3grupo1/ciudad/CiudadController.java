package pe.isil.ep3grupo1.ciudad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    @PostMapping("/add")
    public void addCiudad(@RequestBody Ciudad ciudad){ciudadService.add(ciudad);}

    @PostMapping("/update")
    public void updateItem(@RequestBody Ciudad ciudad, @RequestParam Long id){ciudadService.update(ciudad,id);}
    @GetMapping({"/getall",""})
    public List<Ciudad> getAllItems(){return  ciudadService.getAll();}
    @GetMapping("/getbyid")
    public Ciudad getCiudadbyId(@RequestParam Long id){return ciudadService.getCiudadById(id);}
    @GetMapping("getbydesc")
    public Ciudad getCiudadbyDesc(@RequestParam String descripcion){return  ciudadService.getCiudadByDescripcion(descripcion);}
    @DeleteMapping("/delete")
    public void deleteCiudad(@RequestParam Long id){
        ciudadService.delete(id);
    }
}
