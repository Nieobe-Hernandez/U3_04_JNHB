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

    private Double precioVenta;

    private Double precioRenta;

    private String tamaño;

    @ManyToOne
    @JoinColumn(name = "cede_id")
    private Cede cede;

}
