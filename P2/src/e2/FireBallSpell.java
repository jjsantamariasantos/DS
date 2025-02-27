package e2;

public class FireBallSpell extends Objetos implements ObjetosAtaque {
    int dano;
    int manaMin;
    int usos;
    Boolean haSidoUsado;

    public FireBallSpell(String nombre, int dano, int manaMin, int usos) throws IllegalArgumentException{
        super(nombre);
        if (dano >= 0 && manaMin >=0 && manaMin <= 10 && usos >= 0){
            this.dano = dano;
            this.manaMin = manaMin;
            this.usos = usos;
            this.haSidoUsado = false;
        } else{
            throw new IllegalArgumentException("No se cumplen las condiciones");
        }

    }

    @Override
    public String nombreArma() {
        return getNombre();
    }

    @Override
    public int ataque() {
        int usos =  getUsos();
        int dano = getDanoArma();
        usos = usos -1;
        if (usos == -0){
            dano = dano - 1;
        }
        setUsos(usos);
        return dano;
    }
    @Override
    public int getDanoArma(){
        return getDano();
    }
    @Override
    public int getManaMinimo(){
        return getManaMin();
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getManaMin() {
        return manaMin;
    }

    public void setManaMin(int manaMin) {
        this.manaMin = manaMin;
    }

    @Override
    public int getUsos() {
        return usos;
    }

    @Override
    public void setUsos(int usos) {
        this.usos = usos;
    }

    public Boolean getHaSidoUsado() {
        return haSidoUsado;
    }

    public void setHaSidoUsado(Boolean haSidoUsado) {
        this.haSidoUsado = haSidoUsado;
    }
}
