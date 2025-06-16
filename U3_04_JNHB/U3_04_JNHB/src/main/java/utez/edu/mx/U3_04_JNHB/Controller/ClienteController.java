package utez.edu.mx.U3_04_JNHB.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.U3_04_JNHB.Model.Cliente;
import utez.edu.mx.U3_04_JNHB.Service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}

