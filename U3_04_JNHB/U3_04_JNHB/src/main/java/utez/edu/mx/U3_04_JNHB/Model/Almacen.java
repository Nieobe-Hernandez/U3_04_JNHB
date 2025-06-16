package utez.edu.mx.U3_04_JNHB.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "almacenes")
@Data
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave;

    private LocalDate fechaRegistro;

    private Double precioVenta;

    private String tamaño;

    @ManyToOne
    @JoinColumn(name = "cede_id")
    private Cede cede;

}

