package entidades;

import java.time.LocalDateTime;

public class Intervencion extends Cita {

    // Atributos
    private int minutos; // duracion en minutos

    // Constructores
    public Intervencion() {
    }

    public Intervencion(long id, LocalDateTime fechaYHora, int minutos) {
        super(id, fechaYHora);
        this.minutos = minutos;
    }

    // Getter y Setter
    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    // Metodos
    @Override
    public String toString() {
        return "Intervencion [id=" + getId() + ", fechaYHora=" + getFechaYHoraFormateada() + ", minutos=" + minutos
                + "]";
    }
}
