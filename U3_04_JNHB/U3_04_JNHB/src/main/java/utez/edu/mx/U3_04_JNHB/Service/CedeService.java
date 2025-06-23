package utez.edu.mx.U3_04_JNHB.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.U3_04_JNHB.Model.Cede;
import utez.edu.mx.U3_04_JNHB.Repository.CedeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CedeService {

    private final CedeRepository repository;

    public List<Cede> findAll() {
        return repository.findAll();
    }

    public Optional<Cede> findById(Long id) {
        return repository.findById(id);
    }

    public Cede save(Cede cede) {
        return repository.save(cede);
    }

    public Cede update(Long id, Cede cede) {
        cede.setId(id);
        return repository.save(cede);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
