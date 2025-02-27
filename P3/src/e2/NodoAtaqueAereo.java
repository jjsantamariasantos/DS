package e2;

public class NodoAtaqueAereo extends NodoRutaFija{

    // Caracteristicas

    private final int poderAereo;

    // Cosntructor

    public NodoAtaqueAereo(String nombre, Nodo hijo, int poderAereo) {
        super(nombre, hijo);
        this.poderAereo = poderAereo;
    }

    // Getter

    public int getPoderAereo() {
        return poderAereo;
    }

    // Metodos

    @Override
    public Nodo obtenerSiguienteNodo(Flota flota) {
        if(incursion(flota)) {
            return getHijo();
        }
        return this;
    }

    @Override
    public boolean incursion(Flota flota) {
        if(getPoderAereo() > (flota.getBlindaje() + (2*flota.getAntiaereos()))) {
            flota.setHP(flota.getHP()-(getPoderAereo()-(2*flota.getAntiaereos() + flota.getBlindaje())));
        }
        return flota.getHP() >= 1;
    }

    @Override
    public int minNodo() {
        return 1+getHijo().minNodo();
    }

    @Override
    public String nodoActual() {
        return  "(" +getNombre() + " AirRaid, " + getHijo().nodoActual() + ")";
    }

}
