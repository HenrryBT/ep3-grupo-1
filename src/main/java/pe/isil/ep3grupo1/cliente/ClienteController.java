package pe.isil.ep3grupo1.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/add")
    public void addCliente(@RequestBody Cliente cliente){
        clienteService.add(cliente);
    }

    @PostMapping("/update")
    public void updateCliente(@RequestBody Cliente cliente, @RequestParam Long id){
        clienteService.update(cliente,id);
    }

    @GetMapping({"/getall",""})
    public List<Cliente> getAllItems(){
        return clienteService.getAll();
    }

    @GetMapping("/getbyid")
    public Cliente getItemById(@RequestParam  Long id){
        return clienteService.getClienteById(id);
    }

    @GetMapping({"/getbyemail",""})
    public Cliente getClienteByEmail(@RequestParam String email){
        return clienteService.getClienteByEmail(email);
    }

    @DeleteMapping("/delete")
    public void deleteEmail(@RequestParam Long id){
        clienteService.delete(id);
    }
}
