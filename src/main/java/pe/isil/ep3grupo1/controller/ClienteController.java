package pe.isil.ep3grupo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.isil.ep3grupo1.entity.Cliente;
import pe.isil.ep3grupo1.implementation.ClienteServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteServiceImplementation clienteService;

    @GetMapping({"/getall", ""})
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping("/add")
    public void addCliente(@RequestBody Cliente cliente) {
        clienteService.addClientes(cliente);
    }

    @PostMapping("/update")
    public void updateCliente(@RequestBody Cliente cliente, @RequestParam Long id) {
        clienteService.updateCliente(cliente, id);
    }

    @DeleteMapping("/delete")
    public void deleteCliente(@RequestParam Long id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping("/getbyemail")
    public Cliente getClienteByEmail(@RequestParam String email) {
        return clienteService.getClienteByEmail(email);
    }

    @GetMapping("/getbyciudad")
    public List<Cliente> getClienteByCiudad(@RequestParam String descripcion) {
        return clienteService.getClienteByCiudad(descripcion);
    }


    @GetMapping("/getbypais")
    public List<Cliente> getClienteByPais(@RequestParam String descripcion) {
        return clienteService.getClienteByPais(descripcion);
    }
}
