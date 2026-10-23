package entidades;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    // Atributos
    private Long numeroHistoria;
    private String descripcion;
    private Paciente paciente;
    private List<Alergia> alergias = new ArrayList<>();

    // Constructores
    public Historial() {
    }

    public Historial(long numeroHistoria, String descripcion) {
        this.numeroHistoria = numeroHistoria;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public long getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(long numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Paciente getPaciente() {
        return paciente;
    }


    public void setPaciente(Paciente paciente) {
        if (this.paciente == paciente) {
            return;
        }
        Paciente anterior = this.paciente;
        this.paciente = paciente;
        if (anterior != null && anterior.getHistorial() == this) {
            anterior.setHistorial(null);
        }
        if (paciente != null && paciente.getHistorial() != this) {
            paciente.setHistorial(this);
        }
    }

    public List<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<Alergia> alergias) {
        this.alergias = alergias;
    }

    public void agregarAlergia(Alergia alergia) {
        if (!alergias.contains(alergia)) {
            alergias.add(alergia);
        }
        if (!alergia.getHistoriales().contains(this)) {
            alergia.getHistoriales().add(this);
        }
    }

    public void eliminarAlergia(Alergia alergia) {
        alergias.remove(alergia);
        alergia.getHistoriales().remove(this);
    }

    @Override
    public String toString() {
        return "Historial [numeroHistoria=" + numeroHistoria + ", descripcion=" + descripcion + ", alergias="
                + alergias + "]";
    }
}
