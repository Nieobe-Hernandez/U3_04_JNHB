package utez.edu.mx.U3_04_JNHB.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.U3_04_JNHB.Model.Cliente;
import utez.edu.mx.U3_04_JNHB.Repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente) {
        cliente.setId(id);
        return repository.save(cliente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

