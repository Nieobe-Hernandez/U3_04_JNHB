package utez.edu.mx.U3_04_JNHB.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.U3_04_JNHB.Model.Almacen;
import utez.edu.mx.U3_04_JNHB.Repository.AlmacenRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlmacenService {

    private final AlmacenRepository almacenRepository;

    public List<Almacen> findAll(){
        return almacenRepository.findAll();
    }

    public Almacen findById(Long id){
        return almacenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Almacen no encontrado"));
    }

    public Almacen save(Almacen almacen){
        return almacenRepository.save(almacen);
    }

    public Almacen update(Long id, Almacen almacen){
        Almacen a = findById(id);
        a.setClaveAlmacen(almacen.getClaveAlmacen());
        a.setFechaRegistro(almacen.getFechaRegistro());
        a.setPrecioVenta(almacen.getPrecioVenta());
        a.setPrecioRenta(almacen.getPrecioRenta());
        a.setTamaño(almacen.getTamaño());
        a.setCede(almacen.getCede());
        return almacenRepository.save(a);
    }

    public void delete(Long id){
        Almacen a = findById(id);
        almacenRepository.delete(a);
    }
}
