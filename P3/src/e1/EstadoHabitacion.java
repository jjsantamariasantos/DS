package e1;

public interface EstadoHabitacion {

    // Métodos

    void reservar(Habitacion habitacion, Cliente cliente);
    void terminarReserva(Habitacion habitacion);
    void limpiar(Habitacion habitacion, Trabajador personalLimpieza);
    void aprobarLimpieza(Habitacion habitacion);
    void liberar(Habitacion habitacion);
    void ocupar(Habitacion habitacion);
    void disponibilizar(Habitacion habitacion);
    void cancelarAprobacion(Habitacion habitacion);
}
