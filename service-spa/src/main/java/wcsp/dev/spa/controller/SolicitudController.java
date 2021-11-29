package wcsp.dev.spa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wcsp.dev.spa.entity.Solicitud;
import wcsp.dev.spa.service.SolicitudService;
import wcsp.dev.spa.service.mail.MailService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "spa")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;
    @Autowired
    private MailService mailService;

    @PostMapping(value = "crear")
    public ResponseEntity<Solicitud> listSolicitudes(@RequestBody Solicitud solicitud){

        Boolean ok = solicitudService.valSolicitud(solicitud.getDni());
        if(ok == false){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        Solicitud solicituds = solicitudService.createSolicitud(solicitud);
        mailService.sendMail(solicituds.getCorreo(),"Respuesta a su solicitud", solicituds.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
    }

    @GetMapping(value = "listar")
    public ResponseEntity<List<Solicitud>> listSolicitudes(){
        List<Solicitud> solicituds = new ArrayList<>();
        solicituds = solicitudService.listar();
        return ResponseEntity.ok(solicituds);
    }
}
