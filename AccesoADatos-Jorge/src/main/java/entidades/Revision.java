package entidades;

import java.time.LocalDateTime;

public class Revision extends Cita {

    // Atributos
    private String anotacion;

    // Constructores
    public Revision() {
    }

    public Revision(long id, LocalDateTime fechaYHora, String anotacion) {
        super(id, fechaYHora);
        this.anotacion = anotacion;
    }

    // Getter y Setter
    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    // Metodos
    @Override
    public String toString() {
        return "Revision [id=" + getId() + ", fechaYHora=" + getFechaYHoraFormateada() + ", anotacion=" + anotacion
                + "]";
    }
}
