package wcsp.dev.spa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcsp.dev.spa.entity.Solicitud;
import wcsp.dev.spa.entity.type.Estado;
import wcsp.dev.spa.repository.SolicitudRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public Boolean valSolicitud(String dni) {
        Solicitud sol = solicitudRepository.findByDni(dni);
        if(sol != null){
            return false;
        }
        return true;
    }

    @Override
    public Solicitud createSolicitud(Solicitud solicitud) {
        solicitud.setEstado(Estado.Proceso);
        solicitud.setFechasol(new Date());

        return solicitudRepository.save(solicitud);
    }

    @Override
    public List<Solicitud> listar() {
        return solicitudRepository.findAll();
    }
}
