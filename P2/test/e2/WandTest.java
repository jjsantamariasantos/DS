package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WandTest {

    Wand wand =new Wand("Varita", 5, 8, 5, 5, 3);
    @Test
    void testGetProteccion() {
        assertEquals(5, wand.getProteccion());
    }

    @Test
    void testSetProteccion() {
        wand.setProteccion(20);
        assertEquals(20, wand.getProteccion());
    }

    @Test
    void testGetFuerzaMin() {
        assertEquals(3, wand.getFuerzaMin());
    }

    @Test
    void testSetFuerzaMin() {
        wand.setFuerzaMin(5);
        assertEquals(5, wand.getFuerzaMin());
    }

    @Test
    void testNombreArma() {
        assertEquals("Varita", wand.getNombre());
    }

    @Test
    void testGetDefensa() {
        assertEquals(5, wand.getDefensa());
    }
    @Test
    public void testGetFuerzaMinima() {
        assertEquals(3, wand.getFuerzaMinima());
    }
    @Test
    void testAtaque() {
        int dano1 = wand.ataque();
        int dano2 = wand.ataque();
        int dano3 = wand.ataque();
        assertEquals(10, dano1);
        assertEquals(5, dano2);
        assertEquals(5, dano3);
    }

    @Test
    void testGetDanoArma() {
        assertEquals(5, wand.getDanoArma());
    }

    @Test
    void testGetManaMinimo() {
        assertEquals(8, wand.getManaMinimo());
    }

    @Test
    void testGetDano() {
        assertEquals(5, wand.getDano());
    }

    @Test
    void testSetDano() {
        wand.setDano(2);
        assertEquals(2, wand.getDano());
    }

    @Test
    void testGetManaMin() {
        assertEquals(8, wand.getManaMin());
    }

    @Test
    void testSetManaMin() {
        wand.setManaMin(2);
        assertEquals(2, wand.getManaMin());
    }

    @Test
    void testGetUsos() {
        assertEquals(5, wand.getUsos());
    }

    @Test
    void testSetUsos() {
        wand.setUsos(2);
        assertEquals(2, wand.getUsos());
    }
}