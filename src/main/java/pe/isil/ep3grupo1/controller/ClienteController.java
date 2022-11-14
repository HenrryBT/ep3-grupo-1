package pe.isil.ep3grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.isil.ep3grupo1.entity.Cliente;
import pe.isil.ep3grupo1.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping({"/getall", ""})
    public List<Cliente> getAllClientes() {
        return clienteService.getAll();
    }

    @PostMapping("/add")
    public void addCliente(@RequestBody Cliente cliente) {
        clienteService.add(cliente);
    }

    @PostMapping("/update")
    public void updateCliente(@RequestBody Cliente cliente, @RequestParam Long id) {
        clienteService.update(cliente, id);
    }

    @DeleteMapping("/delete")
    public void deleteCliente(@RequestParam Long id) {
        clienteService.delete(id);
    }

    @GetMapping("/buscarporemail")
    public Cliente getClienteByEmail(@RequestParam String email){
        return clienteService.buscarClientePorEmail(email);
    }
}
