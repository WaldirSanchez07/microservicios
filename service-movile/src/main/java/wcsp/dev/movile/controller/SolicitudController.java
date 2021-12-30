package wcsp.dev.movile.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wcsp.dev.movile.entity.Solicitud;
import wcsp.dev.movile.service.SolicitudService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "movil")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @GetMapping(value = "consultar")
    public ResponseEntity<Solicitud> listSolicitudes(@RequestParam(value = "dni") String dni){
        Solicitud sol;
        sol = solicitudService.getSolicitud(dni);
        if(Objects.isNull(sol)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sol);
    }
}
