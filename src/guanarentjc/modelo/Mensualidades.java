package guanarentjc.modelo;

import java.time.LocalDate;

/**
 * Representa el recibo de cobro mensual generado para un alquiler vigente.
 */
public class Mensualidades {

    public static final String ESTADO_PENDIENTE = "Pendiente";
    public static final String ESTADO_CANCELADO = "Cancelado";

    private int consecutivo;
    private int numAlquiler;
    private LocalDate fechCreacion;
    private String nomInquilino;
    private int mesCobro;
    private int anioActual;
    private double descuento;
    private double montoMes;
    private String estado;

    public Mensualidades() {
    }

    public Mensualidades(int consecutivo, int numAlquiler, LocalDate fechCreacion, String nomInquilino,
            int mesCobro, int anioActual, double descuento, double montoMes, String estado) {
        this.consecutivo = consecutivo;
        this.numAlquiler = numAlquiler;
        this.fechCreacion = fechCreacion;
        this.nomInquilino = nomInquilino;
        this.mesCobro = mesCobro;
        this.anioActual = anioActual;
        this.descuento = descuento;
        this.montoMes = montoMes;
        this.estado = estado;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getNumAlquiler() {
        return numAlquiler;
    }

    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    public LocalDate getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(LocalDate fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    public String getNomInquilino() {
        return nomInquilino;
    }

    public void setNomInquilino(String nomInquilino) {
        this.nomInquilino = nomInquilino;
    }

    public int getMesCobro() {
        return mesCobro;
    }

    public void setMesCobro(int mesCobro) {
        this.mesCobro = mesCobro;
    }

    public int getAnioActual() {
        return anioActual;
    }

    public void setAnioActual(int anioActual) {
        this.anioActual = anioActual;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMontoMes() {
        return montoMes;
    }

    public void setMontoMes(double montoMes) {
        this.montoMes = montoMes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Recibo #" + consecutivo;
    }
}
