package e1;

public class PendienteAprobacion implements EstadoHabitacion{

    // Métodos

    @Override
    public void reservar(Habitacion habitacion, Cliente cliente) throws Error{
        throw new Error("No se cumplen las condiciones para la reserva.");
    }

    @Override
    public void terminarReserva(Habitacion habitacion) throws Error{
        throw new Error("No se cumplen las condiciones para la cancelacion de la reserva.");
    }

    @Override
    public void limpiar(Habitacion habitacion, Trabajador personalLimpieza) throws Error{
        throw new Error("No se cumplen las condiciones para la limpieza.");
    }

    @Override
    public void aprobarLimpieza(Habitacion habitacion) {
        habitacion.setEstadoHabitacion(new Aprobada());
        habitacion.setEstadoActual(Estado.APROBADA);
    }

    @Override
    public void liberar(Habitacion habitacion) throws Error{
        throw new Error("No se cumplen las condiciones para liberar la habitacion.");
    }

    @Override
    public void ocupar(Habitacion habitacion) throws Error{
        throw new Error("No se cumplen las condiciones para ocupar la habitacion.");
    }

    @Override
    public void disponibilizar(Habitacion habitacion) throws Error{
        throw new Error("No se cumplen las condiciones para disponibilizar la habitacion.");
    }

    @Override
    public void cancelarAprobacion(Habitacion habitacion) throws Error {
        throw new Error("No se cumplen las condiciones para cancelar la aprobacion de limpieza.");
    }
}
