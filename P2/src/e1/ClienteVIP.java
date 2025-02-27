package e1;

public class ClienteVIP extends Cliente{

    public ClienteVIP(String DNI, CuentaBancaria cuenta) throws IllegalArgumentException {
        super(DNI, cuenta);
    }

    @Override
    public void puedeIngresar( long ingreso) throws Exception {
        getCuenta().ingresarDineroVIP(ingreso);

    }

    @Override
    public void puedeRetirar(long retiro) throws Exception {
        getCuenta().retirarDineroVIP(retiro);
    }

    @Override
    public double ConsultaSaldo() {
        return getCuenta().getSaldo();
    }
}