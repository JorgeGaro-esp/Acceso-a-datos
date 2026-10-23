package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cita {

    // Atributos    
	private long id;
    private LocalDateTime fechaYHora;
    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private Tratamiento tratamiento;

    // Constructores
    public Cita() {
    }

    public Cita(long id, LocalDateTime fechaYHora) {
        this.id = id;
        this.fechaYHora = fechaYHora;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento nuevo) {
        if (this.tratamiento == nuevo) {
            return;
        }
        Tratamiento anterior = this.tratamiento;
        this.tratamiento = nuevo;
        if (anterior != null) {
            anterior.getCitas().remove(this);
        }
        if (nuevo != null && !nuevo.getCitas().contains(this)) {
            nuevo.getCitas().add(this);
        }
    }

    // Metodos
    public String getFechaYHoraFormateada() {
        return fechaYHora.format(FORMATO);
    }

    @Override
    public String toString() {
        return "Cita [id=" + id + ", fechaYHora=" + getFechaYHoraFormateada() + "]";
    }
}
