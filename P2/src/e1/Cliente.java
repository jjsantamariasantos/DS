    package e1;

    public abstract class Cliente {
        private String DNI;
        private CuentaBancaria cuenta;

        public Cliente(String DNI, CuentaBancaria cuenta) throws IllegalArgumentException{
            if(DNI !=null && cuenta != null){
                this.DNI = DNI;
                this.cuenta = cuenta;
            } else{
                throw new IllegalArgumentException("No se cumplen las condiciones");
            }

        }

        public String getDNI() {
            return DNI;
        }

        public void setDNI(String DNI) {
            this.DNI = DNI;
        }

        public CuentaBancaria getCuenta() {
            return cuenta;
        }

        public void setCuenta(CuentaBancaria cuenta) {
            this.cuenta = cuenta;
        }

        public abstract void puedeIngresar(long ingreso) throws Exception;
        public abstract void puedeRetirar(long retiro) throws Exception;
        public abstract double ConsultaSaldo();
    }
