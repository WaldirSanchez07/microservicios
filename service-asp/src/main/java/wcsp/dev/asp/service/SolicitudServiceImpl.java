package wcsp.dev.asp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcsp.dev.asp.entity.Solicitud;
import wcsp.dev.asp.repository.SolicitudRepository;

import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> listSolicitudes() {
        return solicitudRepository.findAll();
    }
}
