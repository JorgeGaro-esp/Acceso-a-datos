package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {

    // Atributos
    private Long id;
    private String nombreP;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String email;
    private String direccion;
    private String nif; // NIF/NIE
    private Historial historial;
    private List<Tratamiento> tratamientos = new ArrayList<>();

    // Constructores
    public Paciente() {
    }

    public Paciente(long id, String nombreP, LocalDate fechaNacimiento, String telefono, String email,
            String direccion, String nif) {
        this.id = id;
        this.nombreP = nombreP;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.nif = nif;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        if (this.historial == historial) {
            return;
        }
        Historial anterior = this.historial;
        this.historial = historial;
        if (anterior != null && anterior.getPaciente() == this) {
            anterior.setPaciente(null);
        }
        if (historial != null && historial.getPaciente() != this) {
            historial.setPaciente(this);
        }
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public void agregarTratamiento(Tratamiento tratamiento) {
        if (!tratamientos.contains(tratamiento)) {
            tratamientos.add(tratamiento);
        }
        tratamiento.setPaciente(this);
    }

    public void eliminarTratamiento(Tratamiento tratamiento) {
        if (tratamientos.remove(tratamiento)) {
            tratamiento.setPaciente(null);
        }
    }

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nombreP=" + nombreP + ", fechaNacimiento=" + fechaNacimiento
                + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", nif=" + nif
                + "]";
    }
}
