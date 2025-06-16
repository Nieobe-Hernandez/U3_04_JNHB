package utez.edu.mx.U3_04_JNHB.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.U3_04_JNHB.Model.Cede;
import utez.edu.mx.U3_04_JNHB.Repository.CedeRepository;

@Service
@RequiredArgsConstructor
public class CedeService {

    private final CedeRepository repository;

    public Cede guardar(Cede cede) {
        return repository.save(cede);
    }
}
