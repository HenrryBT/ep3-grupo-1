package pe.isil.ep3grupo1.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {
    @Autowired
    private PaisService paisService;


    @PostMapping("/add")
    public void addPais(@RequestBody Pais pais){
        paisService.add(pais);
    }

    @PostMapping("/update")
    public void updatePais(@RequestBody Pais pais, @RequestParam Long id){
        paisService.update(pais,id);
    }

    @GetMapping({"/getall",""})
    public List<Pais> getAllPaises(){
        return paisService.getAll();
    }

    @GetMapping("/getbyid")
    public Pais getItemById(@RequestParam  Long id){
        return paisService.getPaisById(id);
    }

    @GetMapping("/getbyname")
    public Pais getCategoryByName(@RequestParam  String name){
        return paisService.getPaisByName(name);
    }
}
