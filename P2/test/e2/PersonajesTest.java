package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonajesTest {
    private Personajes warrior;
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
        ArrayList<ObjetosDefensa> listaDefensa = new ArrayList<>();
        listaDefensa.add(new Armor("Armadura de Placas", 1, 2));
        listaDefensa.add(new Armor("Capa de Invisibilidad", 1, 2));
        listaDefensa.add(new Sword("Espada", 5, 8, 5, 1, 3));
        listaDefensa.add(new Wand("Varita", 5, 2, 3, 1, 1));

        warrior = new Warrior("Warrior", 20, 5, 8, listaAtaque1, listaDefensa);
        wizard = new Wizard("Wizard", 18, 3, 9, listaAtaque2, listaDefensa);
    }

    void testGetNombre() {
        assertEquals("Warrior", warrior.getNombre());
    }

    @Test
    void testSetNombre() {
        wizard.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", wizard.getNombre());
    }

    @Test
    void testGetVida() {
        assertEquals(20, warrior.getVida());
    }

    @Test
    void testSetVida() {
        wizard.setVida(15);
        assertEquals(15, wizard.getVida());
    }
    @Test
    void testGetFuerza() {
        assertEquals(5, warrior.getFuerza());
    }

    @Test
    void testSetFuerza() {
        warrior.setFuerza(8);
        assertEquals(8, warrior.getFuerza());
    }
    @Test
    void testSetFuerzaException() {
        assertThrows(IllegalArgumentException.class, () -> warrior.setFuerza(-1));
    }

    @Test
    void testGetMana() {
        assertEquals(8, warrior.getMana());
    }

    @Test
    void testSetMana() {
        warrior.setMana(10);
        assertEquals(10, warrior.getMana());
    }
    @Test
    void testSetManaException() {
        assertThrows(IllegalArgumentException.class, () -> warrior.setMana(11));
    }

    @Test
    void testGetListaAtaque() {
        assertNotNull(warrior.getListaAtaque());
        assertEquals(3, warrior.getListaAtaque().size());
    }

    @Test
    void testSetListaAtaque() {
        ArrayDeque<ObjetosAtaque> nuevaListaAtaque = new ArrayDeque<>();
        nuevaListaAtaque.add(new Sword("NuevaEspada", 8, 10, 3, 5, 2));
        warrior.setListaAtaque(nuevaListaAtaque);
        assertEquals(1, warrior.getListaAtaque().size());
    }

    @Test
    void testGetListaDefensa() {
        assertNotNull(warrior.getListaDefensa());
        assertEquals(4, warrior.getListaDefensa().size());
    }

    @Test
    void testSetListaDefensa() {
        ArrayList<ObjetosDefensa> nuevaListaDefensa = new ArrayList<>();
        nuevaListaDefensa.add(new Armor("NuevaArmadura", 12, 3));
        wizard.setListaDefensa(nuevaListaDefensa);
        assertEquals(1, wizard.getListaDefensa().size());
    }
    @Test
    void testSetListaDefensaException() {
        ArrayList<ObjetosDefensa> nuevaListaDefensa = new ArrayList<>();
        nuevaListaDefensa.add(new Armor("NuevaArmadura", 12, 3));
        nuevaListaDefensa.add(new Armor("NuevaArmadura", 12, 3));
        nuevaListaDefensa.add(new Armor("NuevaArmadura", 12, 3));
        nuevaListaDefensa.add(new Armor("NuevaArmadura", 12, 3));
        nuevaListaDefensa.add(new Armor("NuevaArmadura", 12, 3));
        nuevaListaDefensa.add(new Armor("NuevaArmadura", 12, 3));
        assertThrows(IllegalArgumentException.class, () -> wizard.setListaDefensa( nuevaListaDefensa));

    }
    @Test
    void testSetListaAtaqueException() {
        ArrayDeque<ObjetosAtaque> nuevaListaAtaque = new ArrayDeque<>();
        nuevaListaAtaque.add(new Wand("Varita", 5, 7, 3, 6, 1));
        nuevaListaAtaque.add(new Wand("Varita", 5, 7, 3, 6, 1));
        nuevaListaAtaque.add(new Wand("Varita", 5, 7, 3, 6, 1));
        nuevaListaAtaque.add(new Wand("Varita", 5, 7, 3, 6, 1));
        nuevaListaAtaque.add(new Wand("Varita", 5, 7, 3, 6, 1));
        nuevaListaAtaque.add(new Wand("Varita", 5, 7, 3, 6, 1));

        assertThrows(IllegalArgumentException.class, () ->wizard.setListaAtaque(nuevaListaAtaque));

    }

    @Test
    void testAtaque() {
        assertEquals(warrior.ataque(warrior,wizard),1);
    }
}