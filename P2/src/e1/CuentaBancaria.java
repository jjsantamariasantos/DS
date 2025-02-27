package e1;

public abstract class CuentaBancaria {
        private double saldo;
        private String IBAN;

    public CuentaBancaria(String IBAN, double saldo) throws IllegalArgumentException{
        if(IBAN != null && saldo >= 0){
            this.IBAN = IBAN;
            this.saldo = saldo;
        } else{
            throw new IllegalArgumentException("No se cumplen las condiciones");
        }

    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public abstract void retirarDinero(long retiro) throws Exception;

    public abstract void ingresarDinero(long ingreso) throws Exception;

    public abstract void retirarDineroPre(long retiro) throws Exception;
    public abstract void ingresarDineroPre(long ingreso) throws Exception;

    public void ingresarDineroVIP(long ingreso) throws Exception{
        long saldoTemp = (long)(getSaldo() * 100);
        double saldoFinal, temp;

        if(ingreso > 0){
            temp = (double)saldoTemp + (double)ingreso;
            saldoFinal = temp / 100.00;
            System.out.printf("Su nuevo saldo en euros es %.2f.\n", saldoFinal);
            setSaldo(saldoFinal);
        } else{
            throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
        }

    }

    public void retirarDineroVIP(long retiro) throws Exception{
        long saldoTemp = (long)(getSaldo() * 100);
        double saldoFinal, temp;

        if(retiro > 0){
            temp = (double)saldoTemp - (double)retiro;
            saldoFinal = temp / 100.00;
            System.out.printf("Ha retirado un total de %.2f euros.\n",((double)retiro / 100.00));
            System.out.printf("Su nuevo saldo en euros es %.2f.\n", saldoFinal);
            setSaldo(saldoFinal);
        } else{
            throw new Exception("No se cumplen las condiciones para realizar la operacion.\n");
        }
    }
}