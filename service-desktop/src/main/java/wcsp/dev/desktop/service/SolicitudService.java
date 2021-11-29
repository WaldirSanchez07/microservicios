package wcsp.dev.desktop.service;

import wcsp.dev.desktop.entity.Solicitud;

import java.util.List;

public interface SolicitudService {
    public Solicitud getSolicitud(Integer nrooperacion);
    public Solicitud updateSolicitud(Integer nrooperacion, String estado);
    public List<Solicitud> listar();
}
