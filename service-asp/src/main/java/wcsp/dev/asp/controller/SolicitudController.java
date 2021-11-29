package wcsp.dev.asp.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wcsp.dev.asp.entity.Solicitud;
import wcsp.dev.asp.service.SolicitudService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "asp")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping(value = "solicitudes", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Solicitud>> obtenerSolicitud(){
        List<Solicitud> sol = new ArrayList<>();
        sol = solicitudService.listSolicitudes();
        if(sol.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(sol);
    }
}
