package wcsp.dev.spa.entity.type;

public enum Estado {
    Proceso("En Proceso"), Aprobado("Aprobado"), Rechazado("Rechazado");

    private final String estado;

    Estado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
