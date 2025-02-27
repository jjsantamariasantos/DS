package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    CuentaBancaria cuenta = new CuentaCorriente("ES12345678901234567890", 1000.00);
    @Test
    public void testRetirarDinero() {
        try {
            cuenta.retirarDinero(50000);
            assertEquals(500.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testRetirarDineroException() {
        try {
            cuenta.retirarDinero(-150);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testRetirarDineroException2() {
        try {
            cuenta.retirarDinero(150000);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testIngresarDinero() {
        try {
            cuenta.ingresarDinero(20000);
            assertEquals(1200.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testIngresarDineroException(){
        try {
            cuenta.ingresarDinero(-200);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testRetirarDineroPre(){
        try {
            cuenta.retirarDineroPre(50000);
            assertEquals(500.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
    @Test
    public void testRetirarDineroPre2(){
        try {
            cuenta.retirarDineroPre(150000);
            assertEquals(-500.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testRetirarDineroPreException(){
        try {
            cuenta.retirarDineroPre(-200);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testRetirarDineroPreException2(){
        try {
            cuenta.retirarDineroPre(300000);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testingresarDineroVIP(){
        try {
            cuenta.ingresarDineroVIP(20000);
            assertEquals(1200.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
    @Test
    public void testIngresarDineroVIPException(){
        try {
            cuenta.ingresarDineroVIP(-500);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testRetirarDineroVIP(){
        try {
            cuenta.retirarDineroVIP(50000);
            assertEquals(500.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
    @Test
    public void testRetirarDineroVIP2(){
        try {
            cuenta.retirarDineroVIP(200100);
            assertEquals(-1001.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testRetirarDineroVIPException(){
        try {
            cuenta.retirarDineroVIP(-500);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
}