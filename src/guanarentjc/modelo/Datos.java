package guanarentjc.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Administra en memoria todos los ArrayList del sistema (Propietarios,
 * Inquilinos, Viviendas, Alquileres y Mensualidades), junto con las
 * validaciones de llaves únicas y las reglas de negocio de GuanaRent.
 * <p>
 * Se implementa como Singleton para que todas las pantallas compartan
 * la misma información en memoria durante la ejecución del programa.
 */
public class Datos {

    private static Datos instancia;

    private final ArrayList<Propietario> propietarios = new ArrayList<>();
    private final ArrayList<Inquilino> inquilinos = new ArrayList<>();
    private final ArrayList<Vivienda> viviendas = new ArrayList<>();
    private final ArrayList<Alquileres> alquileres = new ArrayList<>();
    private final ArrayList<Mensualidades> mensualidades = new ArrayList<>();

    private Datos() {
        cargarDatosPrueba();
    }

    /**
     * Carga un par de registros de ejemplo en cada ArrayList, para que las
     * pantallas no arranquen vacías durante las pruebas.
     */
    private void cargarDatosPrueba() {
        Propietario p1 = new Propietario("101110111", "Juan Pérez", "Masculino",
                "Liberia, Guanacaste", "8888-1111", "juan@mail.com");
        Propietario p2 = new Propietario("202220222", "María Rodríguez", "Femenino",
                "Nicoya, Guanacaste", "8888-2222", "maria@mail.com");
        insertarPropietario(p1);
        insertarPropietario(p2);

        Inquilino i1 = new Inquilino("303330333", "Carlos Gómez", "Masculino", LocalDate.of(1990, 5, 10),
                "Santa Cruz, Guanacaste", "8888-3333", "carlos@mail.com", "Ingeniero");
        Inquilino i2 = new Inquilino("404440444", "Ana Vindas", "Femenino", LocalDate.of(1988, 11, 20),
                "Tamarindo, Guanacaste", "8888-4444", "ana@mail.com", "Contadora");
        insertarInquilino(i1);
        insertarInquilino(i2);

        Vivienda v1 = new Vivienda(1, "Casa Playa Tamarindo", "Tamarindo, Santa Cruz", 120.0, 300.0,
                "Block", true, 3, 2.5, "Pavimentada", 800000, 400000, p1, Vivienda.ESTADO_DISPONIBLE);
        Vivienda v2 = new Vivienda(2, "Casa Nicoya Centro", "Nicoya centro", 90.0, 200.0,
                "Madera", false, 2, 1.0, "Lastre", 500000, 250000, p2, Vivienda.ESTADO_DISPONIBLE);
        insertarVivienda(v1);
        insertarVivienda(v2);

        Alquileres a1 = new Alquileres(1, LocalDate.of(2026, 1, 15), 12, 2, 1, 400000, 800000, 5,
                i1.getCedInqui(), v1.getIdVivienda(), Alquileres.ESTADO_VIGENTE);
        Alquileres a2 = new Alquileres(2, LocalDate.of(2026, 2, 1), 6, 1, 0, 250000, 500000, 3,
                i2.getCedInqui(), v2.getIdVivienda(), Alquileres.ESTADO_VIGENTE);
        insertarAlquiler(a1);
        insertarAlquiler(a2);
    }

    /**
     * Recarga un JComboBox a partir de una lista, conservando el ítem
     * seleccionado si sigue presente. Evita repetir este bloque en cada
     * pantalla que necesita refrescar un combo (Propietarios, Inquilinos,
     * Viviendas, etc.).
     */
    public static <T> void recargarCombo(javax.swing.JComboBox<T> combo, java.util.List<T> lista) {
        Object seleccionado = combo.getSelectedItem();
        combo.removeAllItems();
        for (T item : lista) {
            combo.addItem(item);
        }
        if (seleccionado != null) {
            combo.setSelectedItem(seleccionado);
        }
    }

    public static Datos getInstancia() {
        if (instancia == null) {
            instancia = new Datos();
        }
        return instancia;
    }

    // ==================== PROPIETARIOS ====================

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public Propietario buscarPropietario(String cedula) {
        for (Propietario p : propietarios) {
            if (p.getCedPropiet().equalsIgnoreCase(cedula)) {
                return p;
            }
        }
        return null;
    }

    public void insertarPropietario(Propietario p) {
        if (buscarPropietario(p.getCedPropiet()) != null) {
            throw new IllegalArgumentException("Ya existe un propietario con la cédula " + p.getCedPropiet());
        }
        propietarios.add(p);
    }

    public void eliminarPropietario(String cedula) {
        for (Vivienda v : viviendas) {
            if (v.getPropietario() != null && v.getPropietario().getCedPropiet().equalsIgnoreCase(cedula)) {
                throw new IllegalStateException("No se puede eliminar: el propietario tiene viviendas registradas");
            }
        }
        propietarios.removeIf(p -> p.getCedPropiet().equalsIgnoreCase(cedula));
    }

    // ==================== INQUILINOS ====================

    public ArrayList<Inquilino> getInquilinos() {
        return inquilinos;
    }

    public Inquilino buscarInquilino(String cedula) {
        for (Inquilino i : inquilinos) {
            if (i.getCedInqui().equalsIgnoreCase(cedula)) {
                return i;
            }
        }
        return null;
    }

    public void insertarInquilino(Inquilino i) {
        if (buscarInquilino(i.getCedInqui()) != null) {
            throw new IllegalArgumentException("Ya existe un inquilino con la cédula " + i.getCedInqui());
        }
        inquilinos.add(i);
    }

    public void eliminarInquilino(String cedula) {
        for (Alquileres a : alquileres) {
            if (a.getCedInquilino().equalsIgnoreCase(cedula)) {
                throw new IllegalStateException("No se puede eliminar: el inquilino tiene alquileres registrados");
            }
        }
        inquilinos.removeIf(i -> i.getCedInqui().equalsIgnoreCase(cedula));
    }

    // ==================== VIVIENDAS ====================

    public ArrayList<Vivienda> getViviendas() {
        return viviendas;
    }

    public Vivienda buscarVivienda(int idVivienda) {
        for (Vivienda v : viviendas) {
            if (v.getIdVivienda() == idVivienda) {
                return v;
            }
        }
        return null;
    }

    public void insertarVivienda(Vivienda v) {
        if (buscarVivienda(v.getIdVivienda()) != null) {
            throw new IllegalArgumentException("Ya existe una vivienda con el id " + v.getIdVivienda());
        }
        if (v.getPropietario() == null || buscarPropietario(v.getPropietario().getCedPropiet()) == null) {
            throw new IllegalArgumentException("El propietario de la vivienda no existe en el registro");
        }
        viviendas.add(v);
    }

    public void eliminarVivienda(int idVivienda) {
        for (Alquileres a : alquileres) {
            if (a.getIdVivienda() == idVivienda) {
                throw new IllegalStateException("No se puede eliminar: la vivienda tiene alquileres registrados");
            }
        }
        viviendas.removeIf(v -> v.getIdVivienda() == idVivienda);
    }

    public int siguienteIdVivienda() {
        int max = 0;
        for (Vivienda v : viviendas) {
            max = Math.max(max, v.getIdVivienda());
        }
        return max + 1;
    }

    // ==================== ALQUILERES ====================

    public ArrayList<Alquileres> getAlquileres() {
        return alquileres;
    }

    public Alquileres buscarAlquiler(int numAlquiler) {
        for (Alquileres a : alquileres) {
            if (a.getNumAlquiler() == numAlquiler) {
                return a;
            }
        }
        return null;
    }

    public int siguienteNumAlquiler() {
        int max = 0;
        for (Alquileres a : alquileres) {
            max = Math.max(max, a.getNumAlquiler());
        }
        return max + 1;
    }

    public void insertarAlquiler(Alquileres a) {
        if (buscarAlquiler(a.getNumAlquiler()) != null) {
            throw new IllegalArgumentException("Ya existe un alquiler con el número " + a.getNumAlquiler());
        }
        if (buscarInquilino(a.getCedInquilino()) == null) {
            throw new IllegalArgumentException("La cédula del inquilino no existe en el registro");
        }
        Vivienda v = buscarVivienda(a.getIdVivienda());
        if (v == null) {
            throw new IllegalArgumentException("El id de vivienda no existe en el registro");
        }
        alquileres.add(a);
        v.setEstado(Vivienda.ESTADO_ALQUILADA);
    }

    public void eliminarAlquiler(int numAlquiler) {
        for (Mensualidades m : mensualidades) {
            if (m.getNumAlquiler() == numAlquiler) {
                throw new IllegalStateException("No se puede eliminar: el alquiler tiene mensualidades generadas");
            }
        }
        alquileres.removeIf(a -> a.getNumAlquiler() == numAlquiler);
    }

    // ==================== MENSUALIDADES ====================

    public ArrayList<Mensualidades> getMensualidades() {
        return mensualidades;
    }

    private int siguienteConsecutivoMensualidad() {
        int max = 0;
        for (Mensualidades m : mensualidades) {
            max = Math.max(max, m.getConsecutivo());
        }
        return max + 1;
    }

    /**
     * Porcentaje de descuento aplicado sobre el precio de alquiler según el
     * mes: temporada baja (ago-set-oct) 10%, media (mar-abr-may-jun-jul) 5%,
     * alta (nov-dic-ene-feb) 0%.
     */
    public double descuentoPorTemporada(int mes) {
        if (mes == 8 || mes == 9 || mes == 10) {
            return 0.10;
        }
        if (mes >= 3 && mes <= 7) {
            return 0.05;
        }
        return 0.0;
    }

    /**
     * Genera un recibo de mensualidad por cada alquiler vigente para el
     * mes/año indicado. No permite generar para un mes/año ya generado ni
     * para una fecha anterior a la actual.
     *
     * @return cantidad de recibos generados
     */
    public int generarMensualidades(int mes, int anio) {
        LocalDate hoy = LocalDate.now();
        LocalDate primerDiaSolicitado = LocalDate.of(anio, mes, 1);
        if (primerDiaSolicitado.isBefore(LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 1))) {
            throw new IllegalArgumentException("No se pueden generar mensualidades para una fecha anterior a la actual");
        }
        int generados = 0;
        for (Alquileres a : alquileres) {
            if (!Alquileres.ESTADO_VIGENTE.equals(a.getEstado())) {
                continue;
            }
            boolean yaExiste = mensualidades.stream()
                    .anyMatch(m -> m.getNumAlquiler() == a.getNumAlquiler() && m.getMesCobro() == mes && m.getAnioActual() == anio);
            if (yaExiste) {
                continue;
            }
            Inquilino inq = buscarInquilino(a.getCedInquilino());
            double descuentoPorc = descuentoPorTemporada(mes);
            double descuentoMonto = a.getPrecioAlquiler() * descuentoPorc;
            double monto = a.getPrecioAlquiler() - descuentoMonto;

            Mensualidades m = new Mensualidades(
                    siguienteConsecutivoMensualidad(),
                    a.getNumAlquiler(),
                    LocalDate.now(),
                    inq != null ? inq.getNomInqui() : "",
                    mes,
                    anio,
                    descuentoMonto,
                    monto,
                    Mensualidades.ESTADO_PENDIENTE);
            mensualidades.add(m);
            generados++;
        }
        if (generados == 0) {
            throw new IllegalStateException("No hay alquileres vigentes pendientes de generar para ese mes/año");
        }
        return generados;
    }

    // ==================== GANANCIAS ====================

    /**
     * Ganancia de GuanaRent en un año: mitad del depósito de garantía de
     * cada alquiler firmado ese año + 7% de cada mensualidad cobrada ese año.
     */
    public double gananciaAnual(int anio) {
        double ganancia = 0;
        for (Alquileres a : alquileres) {
            if (a.getFechContrato() != null && a.getFechContrato().getYear() == anio) {
                ganancia += a.getDepositoGarantia() / 2.0;
            }
        }
        for (Mensualidades m : mensualidades) {
            if (m.getAnioActual() == anio) {
                ganancia += m.getMontoMes() * 0.07;
            }
        }
        return ganancia;
    }

    /**
     * Ganancia de GuanaRent en un mes/año específico, con la misma lógica
     * que {@link #gananciaAnual(int)} pero acotada al mes indicado.
     */
    public double gananciaMensual(int mes, int anio) {
        double ganancia = 0;
        for (Alquileres a : alquileres) {
            if (a.getFechContrato() != null && a.getFechContrato().getYear() == anio
                    && a.getFechContrato().getMonthValue() == mes) {
                ganancia += a.getDepositoGarantia() / 2.0;
            }
        }
        for (Mensualidades m : mensualidades) {
            if (m.getAnioActual() == anio && m.getMesCobro() == mes) {
                ganancia += m.getMontoMes() * 0.07;
            }
        }
        return ganancia;
    }
}
