package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireBallSpellTest {
    FireBallSpell fireBallSpell = new FireBallSpell("Fireball", 20, 10, 3);

    @Test
    void testNombreArma() {
        assertEquals("Fireball", fireBallSpell.nombreArma());
    }

    @Test
    void testAtaque() {
        int dano1 = fireBallSpell.ataque();
        int dano2 = fireBallSpell.ataque();
        int dano3 = fireBallSpell.ataque();
        assertEquals(20, dano1);
        assertEquals(20, dano2);
        assertEquals(19, dano3);
    }

    @Test
    void testGetDanoArma() {
        assertEquals(20, fireBallSpell.getDanoArma());
    }

    @Test
    void testGetManaMinimo() {
        assertEquals(10, fireBallSpell.getManaMinimo());
    }

    @Test
    void testGetDano() {
        assertEquals(20, fireBallSpell.getDano());
    }

    @Test
    void testSetDano() {
        fireBallSpell.setDano(2);
        assertEquals(2, fireBallSpell.getDano());
    }

    @Test
    void testGetManaMin() {
        assertEquals(10, fireBallSpell.getManaMin());
    }

    @Test
    void testSetManaMin() {
        fireBallSpell.setManaMin(2);
        assertEquals(2, fireBallSpell.getManaMin());
    }

    @Test
    void testGetUsos() {
        assertEquals(3, fireBallSpell.getUsos());
    }

    @Test
    void testSetUsos() {
        fireBallSpell.setUsos(2);
        assertEquals(2, fireBallSpell.getUsos());
    }

    @Test
    void testGetHaSidoUsado() {
        assertFalse(fireBallSpell.getHaSidoUsado());
    }

    @Test
    void testSetHaSidoUsado() {
        fireBallSpell.setHaSidoUsado(true);
        assertTrue(fireBallSpell.getHaSidoUsado());
    }
}