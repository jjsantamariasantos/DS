package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaBancariaTest {
    CuentaBancaria cuenta = new CuentaBancaria("ES12345678901234567890", 1000.00) {
        @Override
        public void retirarDinero(long retiro){}
        @Override
        public void ingresarDinero(long ingreso){}
        @Override
        public void retirarDineroPre(long retiro){}

        @Override
        public void ingresarDineroPre(long ingreso){}
    };
    @Test
    public void testGetSaldo(){
        assertEquals(1000.00, cuenta.getSaldo());
    }

    @Test
    public void testSetSaldo(){
        cuenta.setSaldo(1500.0);
        assertEquals(1500.00, cuenta.getSaldo());
    }

    @Test
    public void testGetIBAN(){
        assertEquals("ES12345678901234567890", cuenta.getIBAN());
    }

    @Test
    public void testSetIBAN(){
        cuenta.setIBAN("ES98765432109876543210");
        assertEquals("ES98765432109876543210", cuenta.getIBAN());
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