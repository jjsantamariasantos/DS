package e4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MesaBillarTest {
    private static MesaBillar mesa;
    @BeforeEach
    void setUp() {
        mesa = new MesaBillar();
    }

    @Test
    void partidaIniciada() {
        mesa.iniciarPartida();
        assertTrue(mesa.esPartidaIniciada());

    }

    @Test
    void partidaNoIniciada(){
        assertFalse(mesa.esPartidaIniciada());
    }

    @Test
    void meterBolaBlancaONegra() {
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BLANCA);
        assertTrue(mesa.bolasMesa().contains(BolaBillar.BLANCA));
        mesa.meterBola(BolaBillar.BOLA8);
        assertFalse(mesa.esPartidaIniciada());

    }

    @Test
    void meterBolasNormales(){
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA2);
        assertTrue(mesa.bolasCajetin().contains(BolaBillar.BOLA2));
        assertFalse(mesa.bolasMesa().contains(BolaBillar.BOLA2));

    }

    @Test
    void meterBolasConPartidaNoInciada(){
        assertThrows(IllegalArgumentException.class, ()-> mesa.meterBola(BolaBillar.BOLA15));
    }

    @Test
    void meterBolasQueNoEstanEnMesa(){
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA2);
        assertThrows(IllegalArgumentException.class, ()-> mesa.meterBola(BolaBillar.BOLA2));
    }


    @Test
    void bolasMesaConPartidaInciada() {
        mesa.iniciarPartida();
        assertEquals(BolaBillar.values().length, mesa.bolasMesa().size());
    }

    @Test
    void bolasMesaConPartidaSinIniciar(){
        assertTrue(mesa.bolasMesa().isEmpty());
    }

    @Test
    void bolasMesaDespuesDeMeterBolas(){
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA6);
        assertFalse(mesa.bolasMesa().contains(BolaBillar.BOLA6));
    }

    @Test
    void bolasCajetinConPartidaIniciada(){
        mesa.iniciarPartida();
        assertTrue(mesa.bolasCajetin().isEmpty());
    }

    @Test
    void bolasCajetinSinPartidaIniciada(){
        assertEquals(BolaBillar.values().length, mesa.bolasCajetin().size());
    }

    @Test
    void bolasCajetinDespuesDeMeterBolas(){
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA6);
        assertTrue(mesa.bolasCajetin().contains(BolaBillar.BOLA6));
    }

    @Test
    void obtenerGanadorEmpate(){
        mesa.iniciarPartida();
        assertEquals(mesa.obtenerGanador(),"EMPATE");
    }

    @Test
    void obtenerGanadorLisas(){
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA2);
        assertEquals(mesa.obtenerGanador(),"LISAS");
    }

}