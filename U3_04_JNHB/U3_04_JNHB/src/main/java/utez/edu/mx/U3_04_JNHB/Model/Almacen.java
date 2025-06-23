package utez.edu.mx.U3_04_JNHB.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "almacenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claveAlmacen;
    private LocalDate fechaRegistro;
    private double precioVenta;
    private double precioRenta;

    @Enumerated(EnumType.STRING)
    private Tamano tamano; // G, M, P

    private boolean vendido;
    private boolean rentado;

    @ManyToOne
    @JoinColumn(name = "cede_id")
    private Cede cede;

    public enum Tamano {
        G, M, P
    }
}
