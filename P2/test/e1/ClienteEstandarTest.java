package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEstandarTest {
    CuentaBancaria cuenta1 = new CuentaCorriente("ES12345678901234567890", 1000.0);
    Cliente cliente1 = new ClienteEstandar("123456789", cuenta1);
    CuentaBancaria cuenta2 = new CuentaPlazos("ES09876543210987654321", 1000.0);
    Cliente cliente2 = new ClienteEstandar("123456789", cuenta2);
    @Test
    public void testPuedeIngresar1() {
        try {
            cliente1.puedeIngresar(20000);
            assertEquals(1200.00, cliente1.getCuenta().getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
    @Test
    public void testPuedeIngresar2() {
        try {
            cliente2.puedeIngresar(11000000);
            assertEquals(111000.00, cliente2.getCuenta().getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testPuedeIngresar1Exception() {
        try {
            cliente1.puedeIngresar(-200);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testPuedeIngresar2Exception() {
        try {
            cliente2.puedeIngresar(-200);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testPuedeIngresar2Exception2() {
        try {
            cliente2.puedeIngresar(50000);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testPuedeRetirar1() {
        try {
            cliente1.puedeRetirar(50000);
            assertEquals(500.00, cliente1.getCuenta().getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
    @Test
    public void testPuedeRetirar2() {
        try {
            cliente2.puedeRetirar(35000);
            assertEquals(636.00, cliente2.getCuenta().getSaldo());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testPuedeRetirar1Exception() {
        try {
            cliente1.puedeRetirar(-500);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testPuedeRetirar1Exception2() {
        try {
            cliente1.puedeRetirar(1000000000);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testPuedeRetirar2Exception() {
        try {
            cliente2.puedeRetirar(-500);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testPuedeRetirar2Exception2() {
        try {
            cliente1.puedeRetirar(-500);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }
    @Test
    public void testPuedeRetirar2Exception3() {
        try {
            cliente2.puedeRetirar(200);
            fail("Se esperaba una excepción, pero no se lanzó.");
        } catch (Exception e) {
            assertEquals("No se cumplen las condiciones para realizar la operacion.\n", e.getMessage());
        }
    }

    @Test
    public void testConsultaSaldo1() {

        double saldo = cliente1.ConsultaSaldo();
        assertEquals(1000.00, saldo);
    }
    @Test
    public void testConsultaSaldo2() {

        double saldo = cliente2.ConsultaSaldo();
        assertEquals(1000.00, saldo);
    }
}