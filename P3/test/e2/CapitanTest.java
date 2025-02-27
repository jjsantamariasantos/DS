package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitanTest {
    private Capitan capitan1;
    private Capitan capitan2;

    @BeforeEach
    void setUp() {
        Flota flota1 = new Flota("A",11, 42, 47, 0, 0 );
        Flota flota2 = new Flota("B",1, 25, 0, 46, 28);
        Flota flotaEnemiga1 = new Flota("C",20, 30, 25, 0, 0);
        Flota flotaEnemiga2 = new Flota("D",30, 17, 41, 0, 0);
        NodoFin nodoD = new NodoFin("D");
        NodoFin nodoH = new NodoFin("H");
        NodoFin nodoI = new NodoFin("I");
        NodoFin nodoJ = new NodoFin("J");
        NodoTormentaMarina nodoG = new NodoTormentaMarina("G", nodoI , 67);
        NodoBatalla nodoF = new NodoBatalla("F", nodoH, nodoG, flotaEnemiga2);
        NodoAtaqueAereo nodoE = new NodoAtaqueAereo("E", nodoJ, 151);
        NodoTormentaMarina nodoC = new NodoTormentaMarina("C", nodoF, 20);
        NodoBatalla nodoB = new NodoBatalla("B", nodoD, nodoE, flotaEnemiga1);
        NodoAvistamiento nodoA = new NodoAvistamiento("A", nodoB, nodoC, 28);
        capitan1 = new Capitan(flota1, nodoA);
        capitan2 = new Capitan(flota2, nodoA);
    }

    @Test
    void simularIncursion() {
        assertEquals(capitan1.simularIncursion(), "Sortie Result:\n\tSUCCESS\n\tLast Visited Node: H\n\tFinal HP: 1\n");
        assertEquals(capitan2.simularIncursion(), "Sortie Result:\n\tFAIL\n\tLast Visited Node: E\n\tFinal HP: -33\n");
    }

    @Test
    void numeroMinimoDeNodos() {
        assertEquals(capitan1.numeroMinimoDeNodos(),"Smallest Node Count to End: 3");
        assertEquals(capitan2.numeroMinimoDeNodos(),"Smallest Node Count to End: 3");
    }

    @Test
    void representarMapa() {
        assertEquals(capitan1.representarMapa(),
                "(A WaypointSpotting, (B Battle, (D End), (E AirRaid, (J End))), (C Maelstrom, " +
                        "(F Battle, (H End), (G Maelstrom, (I End)))))");
        assertEquals(capitan2.representarMapa(),
                "(A WaypointSpotting, (B Battle, (D End), (E AirRaid, (J End))), (C Maelstrom, " +
                        "(F Battle, (H End), (G Maelstrom, (I End)))))");
    }

    @Test
    void informacionflota() {
        assertEquals(capitan1.informacionflota(), """
                Flota A
                HP 11
                Blindaje 42
                Poder de Fuego 47
                Antiaereo 0
                Linea de Vision 0
                """);
        assertEquals(capitan2.informacionflota(), """
                Flota B
                HP 1
                Blindaje 25
                Poder de Fuego 0
                Antiaereo 46
                Linea de Vision 28
                """);
    }
}