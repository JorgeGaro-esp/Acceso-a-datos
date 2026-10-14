package entidades;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    // Atributos
    private long numeroHistoria;
    private String descripcion;

    // Relacion 1 a 1: historial propio de un paciente
    private Paciente paciente;

    // Relacion N a M: un historial puede tener varias alergias (o ninguna)
    // y una misma alergia puede estar en varios historiales
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

    // Mantiene sincronizado el otro lado (Paciente.historial)
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

    // Metodos N a M (mantienen sincronizados ambos lados)
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

    // No se incluye el paciente para evitar recursion infinita
    @Override
    public String toString() {
        return "Historial [numeroHistoria=" + numeroHistoria + ", descripcion=" + descripcion + ", alergias="
                + alergias + "]";
    }
}
