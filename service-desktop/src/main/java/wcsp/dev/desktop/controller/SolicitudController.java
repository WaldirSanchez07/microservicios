package wcsp.dev.desktop.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wcsp.dev.desktop.entity.Solicitud;
import wcsp.dev.desktop.service.SolicitudService;
import wcsp.dev.desktop.service.mail.MailService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "desktop")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;
    @Autowired
    private MailService mailService;

    @PutMapping(value = "actualizar/{nro}")
    public ResponseEntity<Solicitud> updateSolicitud(@PathVariable("nro") Integer nro, @RequestBody ObjectNode obj){
        Solicitud solicituds = solicitudService.updateSolicitud(nro,obj.get("estado").asText());
        if(solicituds == null){
            return ResponseEntity.notFound().build();
        }
        mailService.sendMail(solicituds.getCorreo(),"Respuesta a su solicitud", solicituds.toString());
        return ResponseEntity.ok(solicituds);
    }

    @GetMapping(value = "listar")
    public ResponseEntity<List<Solicitud>> listSolicitudes(){
        List<Solicitud> solicituds = new ArrayList<>();
        solicituds = solicitudService.listar();
        return ResponseEntity.ok(solicituds);
    }
}
