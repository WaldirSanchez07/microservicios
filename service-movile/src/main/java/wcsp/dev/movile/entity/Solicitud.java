package wcsp.dev.movile.entity;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "financiera")
@Data
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String dni;
    private String nombres;
    private String correo;
    private Double monto_solicitado;
    private Integer numero_cuotas;
    @Column(columnDefinition = "varchar(10) default 'PENDIENTE'")
    private String estado;
    private Date fecha;

    @Override
    public String toString() {
        return "Datos de su solicitud:\n" +
                "Nro Operación: " + id +
                "\nDNI: " + dni +
                "\nSolicitante: " + nombres +
                "\nCorreo: " + correo +
                "\nMonto Solicitado: " + monto_solicitado +
                "\nNro Cuotas: " + numero_cuotas +
                "\nEstado: " + estado +
                "\nFecha Solicitud: " + new SimpleDateFormat("dd-MM-yyyy").format(fecha);
    }

    public String Respuesta() {
        return "Su solicitud enviada la fecha " + new SimpleDateFormat("dd-MM-yyyy").format(fecha) + "\n " +
                "por el monto de S/" + monto_solicitado + " ha sido: " + estado + "!";
    }
}