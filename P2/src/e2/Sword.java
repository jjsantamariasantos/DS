package e2;

public class Sword extends Objetos implements ObjetosAtaque, ObjetosDefensa {
    int dano;
    int manaMin;
    int usos;
    int proteccion;
    int fuerzaMin;

    public Sword(String nombre, int dano, int manaMin, int usos, int proteccion, int fuerzaMin) throws IllegalArgumentException{
        super(nombre);
        if(dano >= 0 && manaMin >= 0 && manaMin <= 10 && usos >= 0 && proteccion >= 0 && fuerzaMin >= 0 && fuerzaMin <= 10){
            this.dano = dano;
            this.manaMin = manaMin;
            this.usos = usos;
            this.proteccion = proteccion;
            this.fuerzaMin = fuerzaMin;
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
        int dano = getDanoArma();
        int usos = getUsos();
        setUsos(usos - 1);
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
    @Override
    public int getDefensa() {
        return getProteccion();
    }

    @Override
    public int getFuerzaMinima() {
        return getFuerzaMin();
    }

    public int getProteccion() {
        return proteccion;
    }

    public void setProteccion(int proteccion) {
        this.proteccion = proteccion;
    }

    public int getFuerzaMin() {
        return fuerzaMin;
    }

    public void setFuerzaMin(int fuerzaMin) {
        this.fuerzaMin = fuerzaMin;
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
}