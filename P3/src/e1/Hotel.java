package e1;

import java.util.ArrayList;
import java.util.Objects;


public class Hotel {

    // Características

    private final String nombreHotel;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Trabajador> supervisores;
    private ArrayList<Trabajador> personalDeLimpieza;

    // Constructor

    public Hotel(String nombreHotel, ArrayList<Habitacion> habitaciones, ArrayList<Trabajador> supervisores,
                 ArrayList<Trabajador> personalDeLimpieza) throws Error{
        if(cumpleCondicionesBasicas(habitaciones,supervisores,personalDeLimpieza)){
            this.nombreHotel = nombreHotel;
            this.habitaciones = habitaciones;
            this.supervisores = supervisores;
            this.personalDeLimpieza = personalDeLimpieza;
        }else{
            throw new Error("El hotel no cumple las condiciones basicas de creacion.");
        }
    }

    private boolean cumpleCondicionesBasicas(ArrayList<Habitacion> habitaciones, ArrayList<Trabajador> supervisores,
                                             ArrayList<Trabajador> personalDeLimpieza) {
        for (Habitacion temporal : habitaciones) {
            if (temporal.getNumero() <= 0 || temporal.getNumero() > habitaciones.size()) {
                return false;
            }
            boolean incluidoSupervisor = supervisores.stream()
                    .anyMatch(emplimp -> Objects.equals(emplimp.getNombre(),
                            temporal.getSupervisorAsociado().getNombre()));
            boolean incluidoEmpleadoLimpieza = personalDeLimpieza.stream()
                    .anyMatch(emplimp -> Objects.equals(emplimp.getNombre(),
                            temporal.getEmpleadoDeLimpiezaAsociado().getNombre()));

            if (!incluidoSupervisor || !incluidoEmpleadoLimpieza) {
                return false;
            }
        }
        return true;
    }

    // Getters y setters

    public String getNombreHotel() {
        return nombreHotel;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Trabajador> getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(ArrayList<Trabajador> supervisores) {
        this.supervisores = supervisores;
    }

    public ArrayList<Trabajador> getPersonalDeLimpieza() {
        return personalDeLimpieza;
    }

    public void setPersonalDeLimpieza(ArrayList<Trabajador> personalDeLimpieza) {
        this.personalDeLimpieza = personalDeLimpieza;
    }

    // Métodos

    public void agregarHabitacion(Habitacion habitacion) throws Error{
        if(habitacion.getNumero() > 0 && habitacion.getNumero() <= getHabitaciones().size() + 1){
            for (Habitacion temporal : getHabitaciones()){
                if(temporal.getNumero() == habitacion.getNumero()){
                    throw new Error("Esta habitacion ya se encuentra en la lista.");
                }
            }
            for(Trabajador temporal : getSupervisores()){
                if(Objects.equals(temporal.getNombre(), habitacion.getSupervisorAsociado().getNombre())){
                    getHabitaciones().add(habitacion);
                    return;
                }
            }
            throw new Error("Esta habitacion no contiene un supervisor asociado válido");
        }
        throw new Error("Esta habitacion no cumple las condiciones minimas");
    }
    public void eliminarHabitacion(int numeroHabitacion) {
        for (Habitacion temporal : getHabitaciones()){
            if(temporal.getNumero() == numeroHabitacion){
                getHabitaciones().remove(temporal);
                return;
            }
        }
        throw new Error("Esta habitacion no se encuentra en la lista.");
    }

    public Habitacion buscarHabitacion(int numeroHabitacion) throws Error{
        for (Habitacion temporal : getHabitaciones()){
            if(temporal.getNumero() == numeroHabitacion){
                return temporal;
            }
        }
        throw new Error("Esa habitación no se encuentra en nuestro hotel, disculpe las molestias.");
    }

    public Trabajador buscarEmpleadoDeLaLimpieza(String nombre) throws Error{
        for (Trabajador temporal : getPersonalDeLimpieza()){
            if(Objects.equals(temporal.getNombre(), nombre)){
                return temporal;
            }
        }
        throw new Error("No tenemos ningun empleado de la limpieza con esas caracteristicas");
    }

    public void anadirEmpleadoLimpieza(Trabajador empleado) throws Error{
        for (Trabajador temporal : getPersonalDeLimpieza()){
            if(Objects.equals(temporal.getNombre(), empleado.getNombre())){
                throw new Error("Este empleado ya se encuentra en la lista.");
            }
        }
        getPersonalDeLimpieza().add(empleado);
    }

    public void eliminarEmpleadoLimpieza(String nombre) throws Error{
        for (Trabajador temporal : getPersonalDeLimpieza()){
            if(Objects.equals(temporal.getNombre(), nombre)){
                getPersonalDeLimpieza().remove(temporal);
                return;
            }
        }
        throw new Error("Este empleado no se encuentra en la lista.");
    }
    public Trabajador buscarSupervisor(String nombre) throws Error{
        for (Trabajador temporal : getSupervisores()){
            if(Objects.equals(temporal.getNombre(), nombre)){
                return temporal;
            }
        }
        throw new Error("No tenemos ningun supervisor con esas caracteristicas");
    }

    public void anadirSupervisor(Trabajador empleado) throws Error{
        for (Trabajador temporal : getSupervisores()){
            if(Objects.equals(temporal.getNombre(), empleado.getNombre())){
                throw new Error("Este empleado ya se encuentra en la lista.");
            }
        }
        getSupervisores().add(empleado);
    }

    public void eliminarSupervisor(String nombre) throws Error{
        for (Trabajador temporal : getSupervisores()){
            if(Objects.equals(temporal.getNombre(), nombre)){
                getSupervisores().remove(temporal);
                return;
            }
        }
        throw new Error("Este empleado no se encuentra en la lista.");
    }

    public void reservar(int numeroHabitacion, String nombre) throws Error{
        Habitacion habitacionTemp = buscarHabitacion(numeroHabitacion);
        Cliente cliente1 = new Cliente(nombre);
        habitacionTemp.reservar(cliente1);
    }

    public void terminarReserva(int numeroHabitacion) throws Error{
        Habitacion habitacionTemp = buscarHabitacion(numeroHabitacion);
        habitacionTemp.terminarReserva();
    }

    public void limpiar(int numeroHabitacion, String nombreEmpleadoLimpieza) throws Error{
        Habitacion habitacionTemp = buscarHabitacion(numeroHabitacion);
        Trabajador empleadoLimpieza = buscarEmpleadoDeLaLimpieza(nombreEmpleadoLimpieza);
        habitacionTemp.limpiar(empleadoLimpieza);
    }

    public void aprobarLimpieza(int numeroHabitacion, String nombreSupervisor){
        Habitacion habitacionTemp = buscarHabitacion(numeroHabitacion);
        Trabajador supervisor = buscarSupervisor(nombreSupervisor);
        if(supervisor == habitacionTemp.getSupervisorAsociado()){
            habitacionTemp.aprobarLimpieza();
        } else{
            throw new Error("No se cumplen las condiciones para aprobar la habitacion.");
        }
    }

    public void liberar(int numeroHabitacion){
        Habitacion habitacionTemp = buscarHabitacion(numeroHabitacion);
        habitacionTemp.liberar();
    }

    public void ocupar(int numeroHabitacion, String nombreCliente){
        Habitacion habitacionTemp = buscarHabitacion(numeroHabitacion);
        if(habitacionTemp.getTitularDeLaReserva() != null &&
                Objects.equals(nombreCliente, habitacionTemp.getTitularDeLaReserva().getNombre())){
            habitacionTemp.ocupar();
        } else{
            throw new Error("No se cumplen las condiciones para ocupar la habitacion");
        }
    }

    public void disponibilizar(int numeroHabitacion){
        Habitacion habitacionTemp = buscarHabitacion(numeroHabitacion);
        habitacionTemp.disponibilizar();
    }

    public void cancelarAprobacion(int numeroHabitacion, String nombreSupervisor){
        Habitacion habitacionTemp = buscarHabitacion(numeroHabitacion);
        Trabajador supervisor = buscarSupervisor(nombreSupervisor);
        if(supervisor == habitacionTemp.getSupervisorAsociado()){
            habitacionTemp.cancelarAprobacion();
        } else{
            throw new Error("No se cumplen las condiciones para aprobar la habitacion.");
        }
    }

    public ArrayList<Habitacion> listarHabitacionesDisponibles(){
        ArrayList<Habitacion> temporal = new ArrayList<>();
        for(Habitacion temp : getHabitaciones()){
            if(temp.getEstadoActual() == Estado.DISPONIBLE){
                temporal.add(temp);
            }
        }
        return temporal;
    }

    public ArrayList<Habitacion> listarHabitacionesPendienteLimpieza(){
        ArrayList<Habitacion> temporal = new ArrayList<>();
        for(Habitacion temp : getHabitaciones()){
            if(temp.getEstadoActual() == Estado.PENDIENTEDELIMPIEZA){
                temporal.add(temp);
            }
        }
        return temporal;
    }

    public ArrayList<Habitacion> listarHabitacionesPendienteAprobacion(){
        ArrayList<Habitacion> temporal = new ArrayList<>();
        for(Habitacion temp : getHabitaciones()){
            if(temp.getEstadoActual() == Estado.PENDIENTEAPROBACION){
                temporal.add(temp);
            }
        }
        return temporal;
    }

    public String imprimirHotel(){
        StringBuilder info;
        info = new StringBuilder("********************* " + getNombreHotel() + " *********************\n");
        for (Habitacion habitacion : getHabitaciones()) {
            info.append("Roomno.").append(habitacion.getNumero()).append(":").
                    append(obtenerEstadoHabitacion(habitacion));
        }
        info.append("*********************\n");
        return info.toString();
    }

    private String obtenerEstadoHabitacion(Habitacion habitacion) {
        String estado = habitacion.getEstadoActual().toString();
        return switch (estado) {
            case "DISPONIBLE" ->
                    "Free." + "This room was approved by " +
                            habitacion.getSupervisorAsociado().getNombre() + ". Ready to book\n";
            case "RESERVADA" -> "Booked by " +
                    habitacion.getTitularDeLaReserva().getNombre() + ". Free.\n";
            case "OCUPADA" -> "Booked by " +
                    habitacion.getTitularDeLaReserva().getNombre() + ". Occupied.\n";
            case "PENDIENTEDELIMPIEZA" -> "Free. Cleaning pending.\n";
            case "PENDIENTEAPROBACION" ->
                    "Free. Room cleaned by " +
                            habitacion.getEmpleadoDeLimpiezaAsociado().getNombre() + " , pending approval.\n";
            case "APROBADA" -> "Free." + "This room was approved by " +
                    habitacion.getSupervisorAsociado().getNombre() + "\n";
            default -> "";
        };
    }
}
