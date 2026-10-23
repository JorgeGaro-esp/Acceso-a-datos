package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tratamiento {

    // Atributos
    private Long id;
    private String nombreT;
    private LocalDate fechaInicio;
    private boolean consentimiento;
    private Paciente paciente;
    private List<Cita> citas = new ArrayList<>();

    // Constructores
    public Tratamiento() {
    }

    public Tratamiento(long id, String nombreT, LocalDate fechaInicio, boolean consentimiento) {
        this.id = id;
        this.nombreT = nombreT;
        this.fechaInicio = fechaInicio;
        this.consentimiento = consentimiento;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isConsentimiento() {
        return consentimiento;
    }

    public void setConsentimiento(boolean consentimiento) {
        this.consentimiento = consentimiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente nuevo) {
        if (this.paciente == nuevo) {
            return;
        }
        Paciente anterior = this.paciente;
        this.paciente = nuevo;
        if (anterior != null) {
            anterior.getTratamientos().remove(this);
        }
        if (nuevo != null && !nuevo.getTratamientos().contains(this)) {
            nuevo.getTratamientos().add(this);
        }
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

 
    public void agregarCita(Cita cita) {
        if (!citas.contains(cita)) {
            citas.add(cita);
        }
        cita.setTratamiento(this);
    }

    public void eliminarCita(Cita cita) {
        if (citas.remove(cita)) {
            cita.setTratamiento(null);
        }
    }

    @Override
    public String toString() {
        return "Tratamiento [id=" + id + ", nombreT=" + nombreT + ", fechaInicio=" + fechaInicio
                + ", consentimiento=" + consentimiento + ", citas=" + citas + "]";
    }
}
