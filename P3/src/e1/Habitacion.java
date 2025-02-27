package e1;

public class Habitacion {

    // Características

    private final int numero;
    private EstadoHabitacion estadoHabitacion;

    private Estado estadoActual;

    private final Trabajador supervisorAsociado;

    private Trabajador empleadoDeLimpiezaAsociado;

    private Cliente titularDeLaReserva;

    // Constructor

    public Habitacion(int numero, Trabajador supervisorAsociado,
                      Trabajador empleadoDeLimpiezaAsociado) throws Error{
        if(supervisorAsociado != null && empleadoDeLimpiezaAsociado != null){
            this.numero = numero;
            this.estadoHabitacion = new Disponible();
            this.supervisorAsociado = supervisorAsociado;
            this.empleadoDeLimpiezaAsociado =empleadoDeLimpiezaAsociado;
            this.estadoActual = Estado.DISPONIBLE;
            this.titularDeLaReserva = null;
        }else{
            throw new Error("Esta habitación no cumple las condiciones minimas");
        }
    }

    // Getters y setters

    public int getNumero(){
        return numero;
    }

    public EstadoHabitacion getEstadoHabitacion(){
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion){
        this.estadoHabitacion = estadoHabitacion;
    }

    public Trabajador getSupervisorAsociado() {
        return supervisorAsociado;
    }

    public Trabajador getEmpleadoDeLimpiezaAsociado() {
        return empleadoDeLimpiezaAsociado;
    }

    public void setEmpleadoDeLimpiezaAsociado(Trabajador empleadoDeLimpiezaAsociado) {
        this.empleadoDeLimpiezaAsociado = empleadoDeLimpiezaAsociado;
    }

    public Cliente getTitularDeLaReserva() {
        return titularDeLaReserva;
    }

    public void setTitularDeLaReserva(Cliente titularDeLaReserva) {
        this.titularDeLaReserva = titularDeLaReserva;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }


    // Métodos

    public void reservar(Cliente cliente){
        getEstadoHabitacion().reservar(this, cliente);
    }
    public void terminarReserva() {
        getEstadoHabitacion().terminarReserva(this);
    }

    public void limpiar(Trabajador personalLimpieza) {
        getEstadoHabitacion().limpiar(this, personalLimpieza);
    }

    public void aprobarLimpieza() {
        getEstadoHabitacion().aprobarLimpieza(this);
    }

    public void liberar(){
        getEstadoHabitacion().liberar(this);
    }

    public void ocupar(){
        getEstadoHabitacion().ocupar(this);
    }

    public void disponibilizar(){
        getEstadoHabitacion().disponibilizar(this);
    }

    public void cancelarAprobacion(){
        getEstadoHabitacion().cancelarAprobacion(this);
    }
}
