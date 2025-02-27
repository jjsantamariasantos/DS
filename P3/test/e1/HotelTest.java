package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static e1.Estado.*;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    private Hotel hotel;
    private Habitacion habitacion1;
    private Habitacion habitacion2;
    private Cliente cliente1;
    private Trabajador supervisor1;
    private Trabajador limpieza1;
    private Trabajador supervisor2;
    private Trabajador limpieza2;

    @BeforeEach
    void setUp() {
        try {
            cliente1 = new Cliente("Jonhy");
            supervisor1 = new Trabajador("Dracula");
            limpieza1 = new Trabajador("Murray");
            supervisor2 = new Trabajador("Mavis");
            limpieza2 = new Trabajador("Wayne");
            ArrayList<Trabajador> supervisores = new ArrayList<>();
            supervisores.add(supervisor1);
            supervisores.add(supervisor2);
            ArrayList<Trabajador> personalDeLimpieza = new ArrayList<>();
            personalDeLimpieza.add(limpieza1);
            personalDeLimpieza.add(limpieza2);
            habitacion1 = new Habitacion(1, supervisor1, limpieza1);
            habitacion2 = new Habitacion(2, supervisor2, limpieza2);
            ArrayList<Habitacion> habitaciones = new ArrayList<>();
            habitaciones.add(habitacion1);
            habitaciones.add(habitacion2);
            hotel = new Hotel("Hotel Transilvania", habitaciones, supervisores, personalDeLimpieza);
        } catch (Error error) {
            fail("No se esperaba un error: " + error.getMessage());
        }
    }

    @Test
    void agregarHabitacion() {
        try{
            Habitacion habitacionNueva = new Habitacion(3, supervisor1, limpieza1);
            hotel.agregarHabitacion(habitacionNueva);
            assertEquals(3, hotel.getHabitaciones().size());
            assertTrue(hotel.getHabitaciones().contains(habitacionNueva));
        }catch(Error error){
            fail("No se esperaba un error: " + error.getMessage());
        }

    }

    @Test
    public void testAgregarHabitacionExistente() throws Error {
        assertThrows(Error.class, () -> hotel.agregarHabitacion(habitacion1));
    }

    @Test
    void eliminarHabitacion() {
        try{
            hotel.eliminarHabitacion(2);
            assertEquals(1, hotel.getHabitaciones().size());
            assertFalse(hotel.getHabitaciones().contains(habitacion2));
        }catch(Error error){
            fail("No se esperaba un error: " + error.getMessage());
        }
    }

    @Test
    public void testEliminarHabitacionNoExistente() {
        assertThrows(Error.class, () -> hotel.eliminarHabitacion(3));
    }

    @Test
    void buscarHabitacion() {
        Habitacion habitacionEncontrada = hotel.buscarHabitacion(1);
        assertNotNull(habitacionEncontrada);
        assertEquals(habitacionEncontrada, habitacion1);
    }
    @Test
    public void testBuscarHabitacionNoExistente() {
        assertThrows(Error.class, () -> hotel.buscarHabitacion(23));
    }


    @Test
    void buscarEmpleadoDeLaLimpieza() {
        try {
            Trabajador emplimp = hotel.buscarEmpleadoDeLaLimpieza("Wayne");
            assertNotNull(emplimp);
            assertEquals(emplimp, limpieza2);
        }catch (Error error){
            fail("No se esperaba un error: " + error.getMessage());
        }

    }
    @Test
    public void testBuscarEmpleadoLimpiezaNoExistente() {
        assertThrows(Error.class, () -> hotel.buscarEmpleadoDeLaLimpieza("Eunice"));
    }

    @Test
    void anadirEmpleadoLimpieza() {
        try{
            Trabajador emplimp = new Trabajador("Griffin");
            hotel.anadirEmpleadoLimpieza(emplimp);
            assertEquals(3, hotel.getPersonalDeLimpieza().size());
            assertTrue(hotel.getPersonalDeLimpieza().contains(emplimp));
        }catch(Error error){
            fail("No se esperaba un error: " + error.getMessage());
        }
    }

    @Test
    public void testAgregarEmpleadoLimpiezaExistente() throws Error {
        assertThrows(Error.class, () -> hotel.anadirEmpleadoLimpieza(limpieza1));
    }

    @Test
    void eliminarEmpleadoLimpieza() {
        try{
            hotel.eliminarEmpleadoLimpieza("Wayne");
            assertEquals(1, hotel.getPersonalDeLimpieza().size());
            assertFalse(hotel.getPersonalDeLimpieza().contains(limpieza2));
        }catch(Error error){
            fail("No se esperaba un error: " + error.getMessage());
        }
    }

    @Test
    public void testEliminarEmpleadoLimpiezaNoExistente() {
        assertThrows(Error.class, () -> hotel.eliminarEmpleadoLimpieza("Blobby"));
    }

    @Test
    void buscarSupervisor() {
        try {
            Trabajador superv = hotel.buscarSupervisor("Dracula");
            assertNotNull(superv);
            assertEquals(superv, supervisor1);
        }catch (Error error){
            fail("No se esperaba un error: " + error.getMessage());
        }
    }

    @Test
    public void testBuscarSupervisorNoExistente() {
        assertThrows(Error.class, () -> hotel.buscarSupervisor("Dennis"));
    }

    @Test
    void anadirSupervisor() {
        try{
            Trabajador superv = new Trabajador("Frankenstein");
            hotel.anadirSupervisor(superv);
            assertEquals(3, hotel.getSupervisores().size());
            assertTrue(hotel.getSupervisores().contains(superv));
        }catch(Error error){
            fail("No se esperaba un error: " + error.getMessage());
        }
    }

    @Test
    public void testAgregarSupervisorExistente() throws Error {
        assertThrows(Error.class, () -> hotel.anadirSupervisor(supervisor1));
    }

    @Test
    void eliminarSupervisor() {
        try{
            hotel.eliminarSupervisor("Mavis");
            assertEquals(1, hotel.getSupervisores().size());
            assertFalse(hotel.getSupervisores().contains(supervisor2));
        }catch(Error error){
            fail("No se esperaba un error: " + error.getMessage());
        }
    }

    @Test
    void reservar() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        assertEquals(RESERVADA, habitacion1.getEstadoActual());
        assertEquals(cliente1.getNombre(), habitacion1.getTitularDeLaReserva().getNombre());
    }

    @Test
    void reservarHabitacionNoExistente(){
        assertThrows(Error.class, () -> hotel.reservar(0, cliente1.getNombre()));
    }

    @Test
    void terminarReserva() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.terminarReserva(habitacion1.getNumero());
        assertEquals(DISPONIBLE, habitacion1.getEstadoActual());
        assertNull(habitacion1.getTitularDeLaReserva());
    }

    @Test
    void terminarReservaHabitacionNoExistente(){
        assertThrows(Error.class, () -> hotel.terminarReserva(0));
    }

    @Test
    void limpiar() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        assertEquals(PENDIENTEAPROBACION, habitacion1.getEstadoActual());
        assertEquals(limpieza1, habitacion1.getEmpleadoDeLimpiezaAsociado());
    }

    @Test
    void limpiarHabitacionNoExistente(){
        assertThrows(Error.class, () -> hotel.limpiar(0, "Jonhy"));
    }

    @Test
    void limpiarHabitacionEmpleadoNoExistente(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        assertThrows(Error.class, () -> hotel.limpiar(0, "Wanda"));
    }

    @Test
    void aprobarLimpieza() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula");
        assertEquals(APROBADA, habitacion1.getEstadoActual());
    }

    @Test
    void aprobarLimpiezaHabitacionNoExistente(){
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(0, "Dracula"));
    }
    @Test
    void aprobarLimpiezaEmpleadoNoExistente(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(1, "Linda"));
    }

    @Test
    void aprobarLimpiezaEmpleadoNoCorrespondiente(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(1, "Mavis"));
    }

    @Test
    void liberar() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        assertEquals(PENDIENTEDELIMPIEZA, habitacion1.getEstadoActual());
        assertNull(habitacion1.getTitularDeLaReserva());
    }

    @Test
    void liberarHabitacionNoExistente(){
        assertThrows(Error.class, () -> hotel.liberar(0));
    }

    @Test
    void ocupar() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        assertEquals(OCUPADA, habitacion1.getEstadoActual());
    }

    @Test
    void ocuparHabitacionNoExistente(){
        assertThrows(Error.class, () -> hotel.ocupar(0, "Jonhy"));
    }
    @Test
    void ocuparClienteNoExistente(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        assertThrows(Error.class, () -> hotel.ocupar(1, "Fly"));
    }

    @Test
    void disponibilizar() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula");
        hotel.disponibilizar(habitacion1.getNumero());
        assertEquals(DISPONIBLE, habitacion1.getEstadoActual());
        assertNull(habitacion1.getEmpleadoDeLimpiezaAsociado());
    }
    @Test
    void disponibilizarHabitacionNoExistente(){
        assertThrows(Error.class, () -> hotel.disponibilizar(0));
    }

    @Test
    void cancelarAprobacion() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula");
        hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula");
        assertEquals(PENDIENTEAPROBACION, habitacion1.getEstadoActual());
    }

    @Test
    void cancelarAprobacionHabitacionNoExistente(){
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(0, "Dracula"));
    }

    @Test
    void cancelarAprobacionEmpleadoNoExistente(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula");
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(1, "Martha"));
    }

    @Test
    void cancelarAprobacionEmpleadoNoCorrespondiente(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula");
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(1, "Mavis"));
    }
    @Test
    void funcionesConEstadosQueNoDeberian1() {
        assertThrows(Error.class, () -> hotel.ocupar(habitacion1.getNumero(), "Jonhy"));
        assertThrows(Error.class, () -> hotel.liberar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre()));
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.disponibilizar(habitacion1.getNumero()));


    }

    @Test
    void funcionesConEstadosQueNoDeberian2() {
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        assertThrows(Error.class, () -> hotel.liberar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre()));
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.disponibilizar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.reservar(habitacion1.getNumero(), cliente1.getNombre()));
    }

    @Test
    void funcionesConEstadosQueNoDeberian3(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.terminarReserva(habitacion1.getNumero());
        assertThrows(Error.class, () -> hotel.ocupar(habitacion1.getNumero(), "Jonhy"));
        assertThrows(Error.class, () -> hotel.liberar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre()));
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.disponibilizar(habitacion1.getNumero()));

    }

    @Test
    void funcionesConEstadosQueNoDeberian4(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre()));
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.disponibilizar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.reservar(habitacion1.getNumero(), cliente1.getNombre()));
        assertThrows(Error.class, () -> hotel.ocupar(habitacion1.getNumero(), cliente1.getNombre()));
    }

    @Test
    void funcionesConEstadosQueNoDeberian5(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.disponibilizar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.reservar(habitacion1.getNumero(), cliente1.getNombre()));
        assertThrows(Error.class, () -> hotel.ocupar(habitacion1.getNumero(), "Jonhy"));
        assertThrows(Error.class, () -> hotel.liberar(habitacion1.getNumero()));
    }

    @Test
    void funcionesConEstadosQueNoDeberian6(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.disponibilizar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.reservar(habitacion1.getNumero(), cliente1.getNombre()));
        assertThrows(Error.class, () -> hotel.ocupar(habitacion1.getNumero(), "Jonhy"));
        assertThrows(Error.class, () -> hotel.liberar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre()));
    }

    @Test
    void funcionesConEstadosQueNoDeberian7(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula");
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.reservar(habitacion1.getNumero(), cliente1.getNombre()));
        assertThrows(Error.class, () -> hotel.ocupar(habitacion1.getNumero(), "Jonhy"));
        assertThrows(Error.class, () -> hotel.liberar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre()));
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula"));
    }

    @Test
    void funcionesConEstadosQueNoDeberian8(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula");
        hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula");
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.reservar(habitacion1.getNumero(), cliente1.getNombre()));
        assertThrows(Error.class, () -> hotel.ocupar(habitacion1.getNumero(), "Jonhy"));
        assertThrows(Error.class, () -> hotel.liberar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre()));
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.disponibilizar(habitacion1.getNumero()));
    }

    @Test
    void funcionesConEstadosQueNoDeberian9(){
        hotel.reservar(habitacion1.getNumero(), cliente1.getNombre());
        hotel.ocupar(habitacion1.getNumero(), "Jonhy");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula");
        hotel.disponibilizar(habitacion1.getNumero());
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.terminarReserva(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.ocupar(habitacion1.getNumero(), "Jonhy"));
        assertThrows(Error.class, () -> hotel.liberar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre()));
        assertThrows(Error.class, () -> hotel.cancelarAprobacion(habitacion1.getNumero(), "Dracula"));
        assertThrows(Error.class, () -> hotel.disponibilizar(habitacion1.getNumero()));
        assertThrows(Error.class, () -> hotel.aprobarLimpieza(habitacion1.getNumero(), "Dracula"));
    }

    @Test
    void listarHabitacionesDisponibles() {
        assertEquals(hotel.listarHabitacionesDisponibles().size(), 2);
        hotel.reservar(habitacion2.getNumero(), "Quasimosdo");
        assertEquals(hotel.listarHabitacionesDisponibles().size(), 1);
       assertFalse(hotel.listarHabitacionesDisponibles().contains(habitacion2));
        assertTrue(hotel.listarHabitacionesDisponibles().contains(habitacion1));
    }

    @Test
    void listarHabitacionesPendienteLimpieza() {
        assertEquals(hotel.listarHabitacionesPendienteLimpieza().size(), 0);
        hotel.reservar(habitacion2.getNumero(), "Quasimodo");
        hotel.ocupar(habitacion2.getNumero(), "Quasimodo");
        hotel.liberar(habitacion2.getNumero());
        assertEquals(hotel.listarHabitacionesPendienteLimpieza().size(), 1);
        assertFalse(hotel.listarHabitacionesPendienteLimpieza().contains(habitacion1));
        assertTrue(hotel.listarHabitacionesPendienteLimpieza().contains(habitacion2));
    }

    @Test
    void listarHabitacionesPendienteAprobacion() {
        assertEquals(hotel.listarHabitacionesPendienteAprobacion().size(), 0);
        hotel.reservar(habitacion2.getNumero(), "Quasimodo");
        hotel.ocupar(habitacion2.getNumero(), "Quasimodo");
        hotel.liberar(habitacion2.getNumero());
        hotel.limpiar(habitacion2.getNumero(), limpieza1.getNombre());
        assertEquals(hotel.listarHabitacionesPendienteAprobacion().size(), 1);
        assertFalse(hotel.listarHabitacionesPendienteAprobacion().contains(habitacion1));
        assertTrue(hotel.listarHabitacionesPendienteAprobacion().contains(habitacion2));
        hotel.reservar(habitacion1.getNumero(), "Quasimodo");
        hotel.ocupar(habitacion1.getNumero(), "Quasimodo");
        hotel.liberar(habitacion1.getNumero());
        hotel.limpiar(habitacion1.getNumero(), limpieza1.getNombre());
        assertEquals(hotel.listarHabitacionesPendienteAprobacion().size(), 2);
        assertTrue(hotel.listarHabitacionesPendienteAprobacion().contains(habitacion1));
        assertTrue(hotel.listarHabitacionesPendienteAprobacion().contains(habitacion2));
    }

    @Test
    void imprimirHotel() {
        hotel.eliminarHabitacion(2);
        assertEquals(hotel.imprimirHotel(), """
                ********************* Hotel Transilvania *********************
                Roomno.1:Free.This room was approved by Dracula. Ready to book
                *********************
                """);
    }
}