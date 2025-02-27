package e1;

public class ClienteEstandar extends Cliente{

    public ClienteEstandar(String DNI, CuentaBancaria cuenta) throws IllegalArgumentException {
        super(DNI, cuenta);
    }

    @Override
    public void puedeIngresar( long ingreso) throws Exception {
        getCuenta().ingresarDinero(ingreso);

    }

    @Override
    public void puedeRetirar(long retiro) throws Exception {
        getCuenta().retirarDinero(retiro);
    }

    @Override
    public double ConsultaSaldo() {
        return getCuenta().getSaldo();
    }
}
