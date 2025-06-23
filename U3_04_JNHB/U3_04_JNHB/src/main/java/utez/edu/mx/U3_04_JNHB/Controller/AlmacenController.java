package utez.edu.mx.U3_04_JNHB.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.U3_04_JNHB.Model.Almacen;
import utez.edu.mx.U3_04_JNHB.Service.AlmacenService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/almacenes")
@RequiredArgsConstructor
public class AlmacenController {

    private final AlmacenService service;

    @GetMapping
    public List<Almacen> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almacen> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Almacen almacen) {
        try {
            return ResponseEntity.ok(service.save(almacen));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Almacen almacen) {
        try {
            return ResponseEntity.ok(service.update(id, almacen));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/comprar")
    public ResponseEntity<?> comprar(@PathVariable Long id) {
        Optional<Almacen> optional = service.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();
        Almacen almacen = optional.get();
        if (almacen.isRentado() || almacen.isVendido())
            return ResponseEntity.badRequest().body("Este almacén ya está rentado o vendido.");
        almacen.setVendido(true);
        return ResponseEntity.ok(service.save(almacen));
    }

    @PostMapping("/{id}/rentar")
    public ResponseEntity<?> rentar(@PathVariable Long id) {
        Optional<Almacen> optional = service.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();
        Almacen almacen = optional.get();
        if (almacen.isVendido() || almacen.isRentado())
            return ResponseEntity.badRequest().body("Este almacén ya está vendido o rentado.");
        almacen.setRentado(true);
        return ResponseEntity.ok(service.save(almacen));
    }

}
