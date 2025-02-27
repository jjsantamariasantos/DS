package e1;

public class CuentaCorriente extends CuentaBancaria{
    public CuentaCorriente(String IBAN, double saldo) throws IllegalArgumentException{
        super(IBAN, saldo);
    }

    @Override
    public void retirarDinero(long retiro) throws Exception {
        long saldoTemp = (long)(getSaldo() * 100);
        double saldoFinal, temp;


        if ( retiro >0 && retiro <= saldoTemp){
            temp = (double)saldoTemp - (double)retiro;
            saldoFinal = temp / 100.00;
            System.out.printf("Ha retirado un total de %.2f euros.\n",((double)retiro / 100.00));
            System.out.printf("Su nuevo saldo en euros es %.2f.\n", saldoFinal);
            setSaldo(saldoFinal);
        } else{
            throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
        }
    }

    @Override
    public void ingresarDinero(long ingreso) throws Exception{
        long saldoTemp;
        double saldoFinal, temp;


        saldoTemp = (long)(getSaldo() * 100);
        if(ingreso > 0){
            temp = (double)saldoTemp + (double)ingreso;
            saldoFinal = temp / 100.00;
            System.out.printf("Su nuevo saldo en euros es %.2f.\n", saldoFinal);
            setSaldo(saldoFinal);
        } else{
            throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
        }
    }

    @Override
    public void retirarDineroPre(long retiro) throws Exception {
        long saldoTemp = (long)(getSaldo() * 100);
        double saldoFinal, temp;

        if(retiro > 0) {
            temp = (double)saldoTemp - (double)retiro;
            saldoFinal = temp / 100.00;
            if ((saldoFinal) >= -1000.00){
                System.out.printf("Ha retirado un total de %.2f euros.\n",((double)retiro / 100.00));
                System.out.printf("Su nuevo saldo en euros es %.2f.\n", saldoFinal);
                setSaldo(saldoFinal);
            } else{
                throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
            }
         } else{
            throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
        }

    }

    @Override
    public void ingresarDineroPre(long ingreso){}

    @Override
    public void ingresarDineroVIP(long ingreso) throws Exception {
        super.ingresarDineroVIP(ingreso);
    }

    @Override
    public void retirarDineroVIP(long retiro) throws Exception {
        super.retirarDineroVIP(retiro);
    }
}