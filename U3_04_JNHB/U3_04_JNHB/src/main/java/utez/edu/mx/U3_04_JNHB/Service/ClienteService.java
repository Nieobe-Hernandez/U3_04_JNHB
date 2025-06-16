package utez.edu.mx.U3_04_JNHB.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.U3_04_JNHB.Model.Cliente;
import utez.edu.mx.U3_04_JNHB.Repository.ClienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente){
        Cliente c = findById(id);
        c.setNombreCompleto(cliente.getNombreCompleto());
        c.setNumeroTelefono(cliente.getNumeroTelefono());
        c.setCorreoElectronico(cliente.getCorreoElectronico());
        return clienteRepository.save(c);
    }

    public void delete(Long id){
        Cliente c = findById(id);
        clienteRepository.delete(c);
    }
}

