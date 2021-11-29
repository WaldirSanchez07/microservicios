package wcsp.dev.movile.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wcsp.dev.movile.entity.Solicitud;
import wcsp.dev.movile.service.SolicitudService;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "movil")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping(value = "consultar")
    public ResponseEntity<Solicitud> obtenerSolicitud(@Validated @RequestBody ObjectNode body){
        Solicitud sol;

        if(null == body.get("dni").asText()){
            return ResponseEntity.noContent().build();
        }else {
            sol = solicitudService.obtenerSolicitud(body.get("dni").asText());
            if(Objects.isNull(sol)){
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(sol);
    }
}
