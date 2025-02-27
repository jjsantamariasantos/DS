package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
   Armor armor = new Armor("Pesada", 15, 8);

    @Test
    void testGetProteccion() {
        assertEquals(15, armor.getProteccion());
    }

    @Test
    void testSetProteccion() {
        armor.setProteccion(20);
        assertEquals(20, armor.getProteccion());
    }

    @Test
    void testGetFuerzaMin() {
        assertEquals(8, armor.getFuerzaMin());
    }

    @Test
    void testSetFuerzaMin() {
        armor.setFuerzaMin(5);
        assertEquals(5, armor.getFuerzaMin());
    }

    @Test
    void testNombreArma() {
        assertEquals("Pesada", armor.getNombre());
    }

    @Test
    void testGetDefensa() {
        assertEquals(15, armor.getDefensa());
    }
    @Test
    public void testGetFuerzaMinima() {
        assertEquals(8, armor.getFuerzaMinima());
    }

}