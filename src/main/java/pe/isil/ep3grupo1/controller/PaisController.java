package pe.isil.ep3grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.isil.ep3grupo1.entity.Pais;
import pe.isil.ep3grupo1.service.PaisService;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping({"/getall", ""})
    public List<Pais> getAllPaises() {
        return paisService.getAll();
    }

    @PostMapping("/add")
    public void addPais(@RequestBody Pais pais) {
        paisService.add(pais);
    }

    @PostMapping("/update")
    public void updatePais(@RequestBody Pais pais, @RequestParam Long id) {
        paisService.update(pais, id);
    }

    @DeleteMapping("/delete")
    public void deletePais(@RequestParam Long id) {
        paisService.delete(id);
    }
}
