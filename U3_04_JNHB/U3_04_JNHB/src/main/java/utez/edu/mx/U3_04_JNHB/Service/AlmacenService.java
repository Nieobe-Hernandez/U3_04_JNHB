package utez.edu.mx.U3_04_JNHB.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.U3_04_JNHB.Model.Almacen;
import utez.edu.mx.U3_04_JNHB.Repository.AlmacenRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlmacenService {

    private final AlmacenRepository repository;

    public List<Almacen> findAll() {
        return repository.findAll();
    }

    public Optional<Almacen> findById(Long id) {
        return repository.findById(id);
    }

    public Almacen save(Almacen almacen) {
        return repository.save(almacen);
    }


    public Almacen update(Long id, Almacen almacen) {
        almacen.setId(id);
        return save(almacen);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
