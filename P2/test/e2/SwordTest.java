package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
    Sword sword =new Sword("Espada", 5, 8, 5, 5, 3);
    @Test
    void testGetProteccion() {
        assertEquals(5, sword.getProteccion());
    }

    @Test
    void testSetProteccion() {
        sword.setProteccion(20);
        assertEquals(20, sword.getProteccion());
    }

    @Test
    void testGetFuerzaMin() {
        assertEquals(3, sword.getFuerzaMin());
    }

    @Test
    void testSetFuerzaMin() {
        sword.setFuerzaMin(5);
        assertEquals(5, sword.getFuerzaMin());
    }

    @Test
    void testNombreArma() {
        assertEquals("Espada", sword.getNombre());
    }

    @Test
    void testGetDefensa() {
        assertEquals(5, sword.getDefensa());
    }
    @Test
    public void testGetFuerzaMinima() {
        assertEquals(3, sword.getFuerzaMinima());
    }
    @Test
    void testAtaque() {
        int dano1 = sword.ataque();
        int dano2 = sword.ataque();
        int dano3 = sword.ataque();
        assertEquals(5, dano1);
        assertEquals(5, dano2);
        assertEquals(5, dano3);
    }

    @Test
    void testGetDanoArma() {
        assertEquals(5, sword.getDanoArma());
    }

    @Test
    void testGetManaMinimo() {
        assertEquals(8, sword.getManaMinimo());
    }

    @Test
    void testGetDano() {
        assertEquals(5, sword.getDano());
    }

    @Test
    void testSetDano() {
        sword.setDano(2);
        assertEquals(2, sword.getDano());
    }

    @Test
    void testGetManaMin() {
        assertEquals(8, sword.getManaMin());
    }

    @Test
    void testSetManaMin() {
       sword.setManaMin(2);
        assertEquals(2, sword.getManaMin());
    }

    @Test
    void testGetUsos() {
        assertEquals(5, sword.getUsos());
    }

    @Test
    void testSetUsos() {
        sword.setUsos(2);
        assertEquals(2, sword.getUsos());
    }
}