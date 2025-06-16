package utez.edu.mx.U3_04_JNHB.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.U3_04_JNHB.Model.Cede;
import utez.edu.mx.U3_04_JNHB.Service.CedeService;

@RestController
@RequestMapping("/api/cedes")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class CedeController {

    private final CedeService service;

    @PostMapping
    public Cede crear(@Valid @RequestBody Cede cede) {
        return service.guardar(cede);
    }
}
