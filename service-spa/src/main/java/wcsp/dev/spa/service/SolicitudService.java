package wcsp.dev.spa.service;

import wcsp.dev.spa.entity.Solicitud;

import java.util.List;

public interface SolicitudService {

    public Boolean valSolicitud(String dni);
    public Solicitud createSolicitud(Solicitud solicitud);
    public List<Solicitud> listar();
}
