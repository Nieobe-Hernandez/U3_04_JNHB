package utez.edu.mx.U3_04_JNHB.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cedes")
@Data
public class Cede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave;

    private String estado;

    private String municipio;

}

