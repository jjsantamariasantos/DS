package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaPlazosTest {

    CuentaBancaria cuenta = new CuentaPlazos("ES12345678901234567890", 1000.00);
    @Test
    public void testRetirarDinero() {

        try {
            cuenta.retirarDinero(35000);
            assertEquals(636.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
    @Test
    public void testRetirarDineroException() {
        try {
            cuenta.retirarDinero(300000000);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testRetirarDineroException2() {
        try {
            cuenta.retirarDinero(300);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testRetirarDineroException3() {
        try {
            cuenta.retirarDinero(-200);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testIngresarDinero() {
        try {
            cuenta.ingresarDinero(11000000);
            assertEquals(111000.00, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testIngresarDineroException() {
        CuentaBancaria cuenta = new CuentaPlazos("ES12345678901234567890", 1000.0);
        try {
            cuenta.ingresarDinero(50000);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testIngresarDineroException2() {
        CuentaBancaria cuenta = new CuentaPlazos("ES12345678901234567890", 1000.0);
        try {
            cuenta.ingresarDinero(-5000000);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testRetirarDineroPre() {
        try {
            cuenta.retirarDineroPre(120);
            assertEquals(997.80, cuenta.getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testRetirarDineroPreException() {
        try {
            cuenta.retirarDineroPre(-200);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testRetirarDineroPreException2() {
        try {
            cuenta.retirarDineroPre(100);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testIngresarDineroPre() {
        try {
            cuenta.ingresarDineroPre(51000);
            assertEquals(1510.00, cuenta.getSaldo(), 0.001);
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testIngresarDineroPreException() {
        CuentaBancaria cuenta = new CuentaPlazos("ES12345678901234567890", 1000.0);
        try {
            cuenta.ingresarDineroPre(40000);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testIngresarDineroPreException2() {
        CuentaBancaria cuenta = new CuentaPlazos("ES12345678901234567890", 1000.0);
        try {
            cuenta.ingresarDineroPre(-100);
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