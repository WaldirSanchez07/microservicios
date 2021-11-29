package wcsp.dev.desktop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcsp.dev.desktop.entity.Solicitud;
import wcsp.dev.desktop.entity.type.Estado;
import wcsp.dev.desktop.repository.SolicitudRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public Solicitud getSolicitud(Integer nrooperacion) {
        return solicitudRepository.findByNrooperacion(nrooperacion);
    }

    @Override
    public Solicitud updateSolicitud(Integer nrooperacion, String estado) {
        Solicitud solicitud = getSolicitud(nrooperacion);
        if(null == solicitud){
            return null;
        }
        if(estado.equals("Aprobado") == true){
            solicitud.setEstado(Estado.Aprobado);
        }else if(estado.equals("Rechazado") == true){
            solicitud.setEstado(Estado.Rechazado);
        }
        return solicitudRepository.save(solicitud);
    }

    @Override
    public List<Solicitud> listar() {
        return solicitudRepository.findAll();
    }
}
