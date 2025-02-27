package e1;

public class ClientePreferente extends Cliente{


    public ClientePreferente(String DNI, CuentaBancaria cuenta)throws IllegalArgumentException {
        super(DNI, cuenta);
    }

    @Override
    public void puedeIngresar( long ingreso) throws Exception {
        CuentaPlazos cuenta = new CuentaPlazos("E454545", 0.0);
        if(getCuenta().getClass() == cuenta.getClass()){
            getCuenta().ingresarDineroPre(ingreso);
        } else{
            getCuenta().ingresarDinero(ingreso);
        }

    }

    @Override
    public void puedeRetirar(long retiro) throws Exception {
        getCuenta().retirarDineroPre(retiro);
    }

    @Override
    public double ConsultaSaldo() {
        return getCuenta().getSaldo();
    }
}