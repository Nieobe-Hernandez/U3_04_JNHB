package utez.edu.mx.U3_04_JNHB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.U3_04_JNHB.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
