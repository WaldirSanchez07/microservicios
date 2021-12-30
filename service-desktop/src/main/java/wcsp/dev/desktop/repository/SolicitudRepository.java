package wcsp.dev.desktop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wcsp.dev.desktop.entity.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, String> {
    public Solicitud findByDni(String dni);
}
