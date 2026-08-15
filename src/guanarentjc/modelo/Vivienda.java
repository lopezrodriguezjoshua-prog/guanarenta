package guanarentjc.modelo;

/**
 * Representa una vivienda que se ofrece, está o estuvo en alquiler.
 * Se relaciona por agregación con su {@link Propietario}.
 */
public class Vivienda {

    public static final String ESTADO_DISPONIBLE = "Disponible";
    public static final String ESTADO_ALQUILADA = "Alquilada";
    public static final String ESTADO_INACTIVA = "Inactiva";

    private int idVivienda;
    private String descripcion;
    private String direccion;
    private double mtsConstrucc;
    private double mtsLote;
    private String tipoConstruccion;
    private boolean cochera;
    private int cantHabitac;
    private double cantBanios;
    private String carretera;
    private double precioBase;
    private double depositoGarantia;
    private Propietario propietario;
    private String estado;

    public Vivienda() {
    }

    public Vivienda(int idVivienda, String descripcion, String direccion, double mtsConstrucc,
            double mtsLote, String tipoConstruccion, boolean cochera, int cantHabitac,
            double cantBanios, String carretera, double precioBase, double depositoGarantia,
            Propietario propietario, String estado) {
        this.idVivienda = idVivienda;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.mtsConstrucc = mtsConstrucc;
        this.mtsLote = mtsLote;
        this.tipoConstruccion = tipoConstruccion;
        this.cochera = cochera;
        this.cantHabitac = cantHabitac;
        this.cantBanios = cantBanios;
        this.carretera = carretera;
        this.precioBase = precioBase;
        this.depositoGarantia = depositoGarantia;
        this.propietario = propietario;
        this.estado = estado;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getMtsConstrucc() {
        return mtsConstrucc;
    }

    public void setMtsConstrucc(double mtsConstrucc) {
        this.mtsConstrucc = mtsConstrucc;
    }

    public double getMtsLote() {
        return mtsLote;
    }

    public void setMtsLote(double mtsLote) {
        this.mtsLote = mtsLote;
    }

    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public boolean isCochera() {
        return cochera;
    }

    public void setCochera(boolean cochera) {
        this.cochera = cochera;
    }

    public int getCantHabitac() {
        return cantHabitac;
    }

    public void setCantHabitac(int cantHabitac) {
        this.cantHabitac = cantHabitac;
    }

    public double getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(double cantBanios) {
        this.cantBanios = cantBanios;
    }

    public String getCarretera() {
        return carretera;
    }

    public void setCarretera(String carretera) {
        this.carretera = carretera;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getDepositoGarantia() {
        return depositoGarantia;
    }

    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idVivienda + " - " + descripcion;
    }
}
