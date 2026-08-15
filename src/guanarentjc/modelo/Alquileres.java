package guanarentjc.modelo;

import java.time.LocalDate;

/**
 * Representa el contrato de alquiler de una vivienda con un inquilino.
 */
public class Alquileres {

    public static final String ESTADO_VIGENTE = "Vigente";
    public static final String ESTADO_VENCIDO = "Vencido";
    public static final String ESTADO_CANCELADO = "Cancelado";

    private int numAlquiler;
    private LocalDate fechContrato;
    private int cantMeses;
    private int numAdultos;
    private int numNinos;
    private double depositoGarantia;
    private double precioAlquiler;
    private double porcIncremAnual;
    private String cedInquilino;
    private int idVivienda;
    private String estado;

    public Alquileres() {
    }

    public Alquileres(int numAlquiler, LocalDate fechContrato, int cantMeses, int numAdultos,
            int numNinos, double depositoGarantia, double precioAlquiler, double porcIncremAnual,
            String cedInquilino, int idVivienda, String estado) {
        this.numAlquiler = numAlquiler;
        this.fechContrato = fechContrato;
        this.cantMeses = cantMeses;
        this.numAdultos = numAdultos;
        this.numNinos = numNinos;
        this.depositoGarantia = depositoGarantia;
        this.precioAlquiler = precioAlquiler;
        this.porcIncremAnual = porcIncremAnual;
        this.cedInquilino = cedInquilino;
        this.idVivienda = idVivienda;
        this.estado = estado;
    }

    public int getNumAlquiler() {
        return numAlquiler;
    }

    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    public LocalDate getFechContrato() {
        return fechContrato;
    }

    public void setFechContrato(LocalDate fechContrato) {
        this.fechContrato = fechContrato;
    }

    public int getCantMeses() {
        return cantMeses;
    }

    public void setCantMeses(int cantMeses) {
        this.cantMeses = cantMeses;
    }

    public int getNumAdultos() {
        return numAdultos;
    }

    public void setNumAdultos(int numAdultos) {
        this.numAdultos = numAdultos;
    }

    public int getNumNinos() {
        return numNinos;
    }

    public void setNumNinos(int numNinos) {
        this.numNinos = numNinos;
    }

    public double getDepositoGarantia() {
        return depositoGarantia;
    }

    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public double getPorcIncremAnual() {
        return porcIncremAnual;
    }

    public void setPorcIncremAnual(double porcIncremAnual) {
        this.porcIncremAnual = porcIncremAnual;
    }

    public String getCedInquilino() {
        return cedInquilino;
    }

    public void setCedInquilino(String cedInquilino) {
        this.cedInquilino = cedInquilino;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alquiler #" + numAlquiler;
    }
}
