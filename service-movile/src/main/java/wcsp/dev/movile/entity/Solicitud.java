package wcsp.dev.movile.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "solicitud")
@Data
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nrooperacion;
    private String dni;
    private String nombre;
    private String otrosnombres;
    private String apaterno;
    private String amaterno;

    @Temporal(TemporalType.DATE)
    private Date fechanac;

    private String direccion;
    private String telefono;
    private String correo;
    private Double ingmensual;
    private Double monto;
    private String estado;
    private String fechasol;
}
