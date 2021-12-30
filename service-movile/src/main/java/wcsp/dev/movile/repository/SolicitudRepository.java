package wcsp.dev.movile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wcsp.dev.movile.entity.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud,Integer> {
    public Solicitud findByDni(String dni);
}
