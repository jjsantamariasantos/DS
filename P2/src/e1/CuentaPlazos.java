package e1;

public class CuentaPlazos extends  CuentaBancaria{
    private static final long PORCENTAJE_COMISION = 4;
    private static final long LIMITE_RETIRO = 300;
    private static final long LIMITE_INGRESO = 100000;
    private static final long PORCENTAJE_COMISION_PRE = 2;
    private static final long LIMITE_RETIRO_PRE = 100;
    private static final long LIMITE_INGRESO_PRE = 50000;

    public CuentaPlazos(String IBAN, double saldo) throws IllegalArgumentException {
        super(IBAN, saldo);
    }

    @Override
    public void retirarDinero(long retiro) throws Exception{
        long saldoTemp = (long)(getSaldo() * 100), comision;
        double saldoFinal, temp;


        if (retiro <= saldoTemp && retiro > LIMITE_RETIRO){
            comision = (retiro * PORCENTAJE_COMISION) / 100;
            if(comision < LIMITE_RETIRO){
                comision = LIMITE_RETIRO;
            }
            temp = (double)saldoTemp - (double)retiro - (double)comision;
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


        if(ingreso > LIMITE_INGRESO){
            saldoTemp = (long)(getSaldo() * 100);
            temp = (double)saldoTemp + (double)ingreso;
            saldoFinal = temp / 100.00;
            System.out.printf("Su nuevo saldo en euros es %.2f.\n", saldoFinal);
            setSaldo(saldoFinal);
        } else{
            throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
        }
    }

    @Override
    public void retirarDineroPre(long retiro) throws Exception{
        long saldoTemp = (long)(getSaldo() * 100), comision;
        double saldoFinal, temp;


        if (retiro > LIMITE_RETIRO_PRE){
            comision = (retiro * PORCENTAJE_COMISION_PRE) / 100;
            if(comision < LIMITE_RETIRO_PRE){
                comision = LIMITE_RETIRO_PRE;
            }
            temp = (double)saldoTemp - (double)retiro - (double)comision;
            saldoFinal = temp / 100.00;
            if(saldoFinal >= -1000.00){
                System.out.printf("Ha retirado un total de %.2f euros.\n",((double)retiro / 100.00));
                System.out.printf("Su nuevo saldo en euros es %.2f.\n", saldoFinal);
                setSaldo(saldoFinal);
            } else {
                throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
            }
        } else{
            throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
        }
    }

    public void ingresarDineroPre(long ingreso) throws Exception{
        long saldoTemp = (long)(getSaldo() * 100);
        double saldoFinal, temp;


        if(ingreso > LIMITE_INGRESO_PRE){
            temp = (double)saldoTemp + (double)ingreso;
            saldoFinal = temp / 100.00;
            System.out.printf("Su nuevo saldo en euros es %.2f.\n", saldoFinal);
            setSaldo(saldoFinal);
        } else{
            throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
        }
    }

    @Override
    public void ingresarDineroVIP(long ingreso) throws Exception {
        super.ingresarDineroVIP(ingreso);
    }

    @Override
    public void retirarDineroVIP(long retiro) throws Exception {
        super.retirarDineroVIP(retiro);
    }
}