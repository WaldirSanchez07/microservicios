package wcsp.dev.asp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcsp.dev.asp.entity.Solicitud;
import wcsp.dev.asp.repository.SolicitudRepository;

import java.util.Date;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService{
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public Solicitud createSolicitud(Solicitud solicitud) {
        solicitud.setEstado("PENDIENTE");
        java.util.Date fecha = new Date();
        solicitud.setFecha(fecha);
        return solicitudRepository.save(solicitud);
    }

    @Override
    public List<Solicitud> listar() {
        return solicitudRepository.findAll();
    }

    @Override
    public Solicitud getSolicitud(String dni) {
        return solicitudRepository.findByDni(dni);
    }

    @Override
    public Solicitud updateSolicitud(String dni, Integer estado) {
        Solicitud solicitud = getSolicitud(dni);
        if(null == solicitud){
            return null;
        }
        if(estado == 0){
            solicitud.setEstado("RECHAZADO");
        }else if(estado == 1){
            solicitud.setEstado("APROBADO");
        }

        return solicitudRepository.save(solicitud);
    }

    @Override
    public String deleteSolicitud(String dni) {
        Solicitud sol = getSolicitud(dni);
        if(null == sol){
            return null;
        }
        solicitudRepository.delete(sol);
        return "Eliminado";
    }
}
