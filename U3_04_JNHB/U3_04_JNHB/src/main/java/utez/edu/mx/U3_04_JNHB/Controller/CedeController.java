package utez.edu.mx.U3_04_JNHB.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.U3_04_JNHB.Model.Cede;
import utez.edu.mx.U3_04_JNHB.Service.CedeService;

import java.util.List;

@RestController
@RequestMapping("/api/cedes")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class CedeController {

    private final CedeService service;

    @GetMapping
    public List<Cede> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cede> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cede> create(@RequestBody Cede cede) {
        return ResponseEntity.ok(service.save(cede));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cede> update(@PathVariable Long id, @RequestBody Cede cede) {
        return ResponseEntity.ok(service.update(id, cede));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
