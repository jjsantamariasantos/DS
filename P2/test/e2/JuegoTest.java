package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {

    private Juego juego;
    private Juego juego2;
    private Personajes warrior;
    private Personajes warrior2;
    private Personajes wizard;
    @BeforeEach
    public void setUp() {
        ArrayDeque<ObjetosAtaque> listaAtaque1 = new ArrayDeque<>();
        listaAtaque1.add(new Wand("Varita", 5, 9, 3, 6, 1));
        listaAtaque1.add(new FireBallSpell("Bola de Fuego", 2, 10, 3));
        listaAtaque1.addFirst(new Sword("Espada", 5, 8, 5, 5, 3));
        ArrayDeque<ObjetosAtaque> listaAtaque2 = new ArrayDeque<>();
        listaAtaque2.add(new Wand("Varita", 5, 7, 3, 6, 1));
        listaAtaque2.add(new FireBallSpell("Bola de Fuego", 2, 7, 3));
        listaAtaque2.addFirst(new Sword("Espada", 1, 8, 5, 5, 3));
        ArrayDeque<ObjetosAtaque> listaAtaque3 = new ArrayDeque<>();
        listaAtaque3.add(new Wand("Varita", 5, 9, 3, 6, 1));
        listaAtaque3.add(new FireBallSpell("Bola de Fuego", 2, 10, 3));
        listaAtaque3.addFirst(new Sword("Espada", 20, 8, 5, 5, 3));
        ArrayList<ObjetosDefensa> listaDefensa = new ArrayList<>();
        listaDefensa.add(new Armor("Armadura de Placas", 1, 2));
        listaDefensa.add(new Armor("Capa de Invisibilidad", 1, 2));
        listaDefensa.add(new Sword("Espada", 5, 8, 5, 1, 3));
        listaDefensa.add(new Wand("Varita", 5, 10, 3, 1, 1));

        warrior = new Warrior("Warrior", 20, 5, 8, listaAtaque1, listaDefensa);
        warrior2 = new Warrior("Warrior2", 20, 5, 8, listaAtaque3, listaDefensa);
        wizard = new Wizard("Wizard", 18, 3, 9, listaAtaque2, listaDefensa);
        juego = new Juego(warrior,wizard,5);
        juego2 = new Juego(warrior2,wizard,15);
    }
    @Test
    void testSimularAtaque() {
        assertEquals(juego.simularAtaque(),1);
    }

    @Test
    void testCombate() {
        Personajes ganador = juego.combate();
        Personajes ganador2 = juego2.combate();


        assertNull(ganador);
        assertEquals(ganador2, warrior2);
    }

    @Test
    void testGetPersonaje1() {
        assertEquals(juego.getPersonaje1(), warrior);
    }

    @Test
    void testSetPersonaje1() {
        juego.setPersonaje1(wizard);
        assertEquals(juego.getPersonaje1(), wizard);
    }

    @Test
    void testGetPersonaje2() {
        assertEquals(juego2.getPersonaje2(), wizard);
    }

    @Test
    void testSetPersonaje2() {
        juego2.setPersonaje2(warrior2);
        assertEquals(juego2.getPersonaje1(), warrior2);
    }

    @Test
    void testGetTurnos() {
        assertEquals(juego.getTurnos(),5);
    }

    @Test
    void testSetTurnos() {
        juego.setTurnos(2);
        assertEquals(juego.getTurnos(),2);
    }
}