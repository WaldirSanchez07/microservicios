package wcsp.dev.asp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wcsp.dev.asp.entity.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud,Integer> {

}
