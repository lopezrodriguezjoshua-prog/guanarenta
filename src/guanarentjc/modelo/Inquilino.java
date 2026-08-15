package guanarentjc.modelo;

import java.time.LocalDate;

/**
 * Representa a una persona que arrienda o ha arrendado alguna vivienda.
 */
public class Inquilino {

    private String cedInqui;
    private String nomInqui;
    private String genero;
    private LocalDate fechNac;
    private String direccion;
    private String telefono;
    private String email;
    private String ocupacion;

    public Inquilino() {
    }

    public Inquilino(String cedInqui, String nomInqui, String genero, LocalDate fechNac,
            String direccion, String telefono, String email, String ocupacion) {
        this.cedInqui = cedInqui;
        this.nomInqui = nomInqui;
        this.genero = genero;
        this.fechNac = fechNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
    }

    public String getCedInqui() {
        return cedInqui;
    }

    public void setCedInqui(String cedInqui) {
        this.cedInqui = cedInqui;
    }

    public String getNomInqui() {
        return nomInqui;
    }

    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return nomInqui + " (" + cedInqui + ")";
    }
}
