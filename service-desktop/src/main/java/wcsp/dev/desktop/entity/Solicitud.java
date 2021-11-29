package wcsp.dev.desktop.entity;

import lombok.Data;
import wcsp.dev.desktop.entity.type.Estado;

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

    //@Enumerated(EnumType.ORDINAL)
    private Estado estado;

    @Temporal(TemporalType.DATE)
    private Date fechasol;

    @Override
    public String toString() {
        return "Solicitud:\n" +
                "nrooperacion: " + nrooperacion +
                "\ndni: " + dni+
                "\nnombre: " + nombre +
                "\notrosnombres: " + otrosnombres +
                "\napaterno: " + apaterno +
                "\namaterno: " + amaterno +
                "\nfechanac: " + fechanac +
                "\ndireccion: " + direccion +
                "\ntelefono: " + telefono +
                "\ncorreo: " + correo +
                "\ningmensual: " + ingmensual +
                "\nmonto: " + monto +
                "\nestado: " + estado +
                "\nfechasol: " + fechasol;
    }
}
