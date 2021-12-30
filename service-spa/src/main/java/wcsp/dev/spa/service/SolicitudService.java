package wcsp.dev.spa.service;

import wcsp.dev.spa.entity.Solicitud;

import java.util.List;

public interface SolicitudService {
    public Solicitud createSolicitud(Solicitud solicitud);
    public List<Solicitud> listar();
    public Solicitud getSolicitud(String dni);
    public Solicitud updateSolicitud(String dni, Integer op);
    public String deleteSolicitud(String dni);
}
