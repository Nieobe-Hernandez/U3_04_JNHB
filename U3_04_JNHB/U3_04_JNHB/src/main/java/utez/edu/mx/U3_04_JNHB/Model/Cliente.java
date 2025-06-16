package utez.edu.mx.U3_04_JNHB.Model;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    private String numeroTelefono;

    private String correoElectronico;

}

