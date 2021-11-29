package wcsp.dev.movile.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcsp.dev.movile.entity.Solicitud;
import wcsp.dev.movile.repository.SolicitudRepository;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService{
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public Solicitud obtenerSolicitud(String dni) {
        return solicitudRepository.findByDni(dni);
    }
}
