package utez.edu.mx.U3_04_JNHB.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.U3_04_JNHB.Model.Almacen;
import utez.edu.mx.U3_04_JNHB.Service.AlmacenService;

import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
@RequiredArgsConstructor
public class AlmacenController {

    private final AlmacenService almacenService;

    @GetMapping
    public List<Almacen> findAll(){
        return almacenService.findAll();
    }

    @GetMapping("/{id}")
    public Almacen findById(@PathVariable Long id){
        return almacenService.findById(id);
    }

    @PostMapping
    public Almacen save(@RequestBody Almacen almacen){
        return almacenService.save(almacen);
    }

    @PutMapping("/{id}")
    public Almacen update(@PathVariable Long id, @RequestBody Almacen almacen){
        return almacenService.update(id, almacen);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        almacenService.delete(id);
    }
}
