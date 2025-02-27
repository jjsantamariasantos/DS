package e2;

public class Armor extends Objetos implements ObjetosDefensa {
    int proteccion;
    int fuerzaMin;

    public Armor(String nombre, int proteccion, int fuerzaMin)throws IllegalArgumentException {
        super(nombre);
        if(proteccion >= 0 && fuerzaMin >= 1 && fuerzaMin <=10){
            this.proteccion = proteccion;
            this.fuerzaMin = fuerzaMin;
        } else {
            throw new IllegalArgumentException("No se cumplen las condiciones");
        }

    }

    @Override
    public String nombreArma() {
        return getNombre();
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
}
