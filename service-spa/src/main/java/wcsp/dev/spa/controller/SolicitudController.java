package wcsp.dev.spa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wcsp.dev.spa.entity.Solicitud;
import wcsp.dev.spa.service.SolicitudService;
import wcsp.dev.spa.service.mail.MailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "spa")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;
    @Autowired
    private MailService mailService;

    @PostMapping(value = "registrar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Solicitud> saveSolicitudes(@RequestBody Solicitud solicitud){
        Solicitud sol = solicitudService.getSolicitud(solicitud.getDni());
        if(sol != null){
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode objMsg = mapper.createObjectNode();
            objMsg.put("mensaje", "Usted ya tiene una solicitud registrada.");
            return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).build();
        }

        Solicitud solicituds = solicitudService.createSolicitud(solicitud);
        if(Objects.isNull(solicituds)){
            return ResponseEntity.noContent().build();
        }

        mailService.sendMail(solicituds.getCorreo(),"Solicitud Registrada", solicituds.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
    }

    @GetMapping(value = "listar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Solicitud>> listSolicitudes(){
        List<Solicitud> solicituds = new ArrayList<>();
        solicituds = solicitudService.listar();
        return ResponseEntity.ok(solicituds);
    }

    @GetMapping(value = "listar-solicitudes", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Solicitud>> listAll(){
        List<Solicitud> solicituds = new ArrayList<>();
        solicituds = solicitudService.listar();
        return ResponseEntity.ok(solicituds);
    }

    @GetMapping(value = "consultar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Solicitud> listSolicitudes(@RequestParam(value = "dni") String dni){
        Solicitud sol;
        sol = solicitudService.getSolicitud(dni);
        if(Objects.isNull(sol)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sol);
    }

    @PutMapping(value = "actualizar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Solicitud> updateSolicitud(@RequestBody ObjectNode obj){
        Solicitud sol = solicitudService.updateSolicitud(obj.get("dni").asText(), obj.get("estado").asInt());
        if(Objects.isNull(sol)){
            return ResponseEntity.noContent().build();
        }

        mailService.sendMail(sol.getCorreo(),"Respuesta a su Solicitud", sol.Respuesta());
        return ResponseEntity.ok(sol);
    }

    @DeleteMapping(value = "eliminar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> deleteSolicitudes(@RequestParam(value = "dni") String dni){
        String msj = "";
        if(null == dni){
            return ResponseEntity.noContent().build();
        }else {
            msj = solicitudService.deleteSolicitud(dni);
            if(msj == null){
                return ResponseEntity.noContent().build();
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objMsg = mapper.createObjectNode();
        objMsg.put("mensaje", "La solicitud con el DNI: "+dni+" ha sido eliminada.");
        return ResponseEntity.ok(objMsg);
    }
}
