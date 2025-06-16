package utez.edu.mx.U3_04_JNHB.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cedes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave;

    private String estado;

    private String municipio;

}

