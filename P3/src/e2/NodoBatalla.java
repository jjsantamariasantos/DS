package e2;

public class NodoBatalla extends NodoBifurcacion {

    // Caracteristicas

    private final Flota enemigo;

    // Constructor

    public NodoBatalla(String nombre, Nodo hijoIzquierdo, Nodo hijoDerecho, Flota enemigo) {
        super(nombre, hijoIzquierdo, hijoDerecho);
        this.enemigo = enemigo;
    }

    // Getter

    public Flota getEnemigo() {
        return enemigo;
    }

    // Metodos

    @Override
    public Nodo obtenerSiguienteNodo(Flota flota) {
        if (incursion(flota)){
            return getHijoIzquierdo();
        } else{
            return getHijoDerecho();
        }
    }

    @Override
    public boolean incursion(Flota flota) {
        if(getEnemigo().getPoderFuego() > flota.getBlindaje()) {
            flota.setHP(flota.getHP()-(getEnemigo().getPoderFuego()-flota.getBlindaje()));
        }
        if(flota.getPoderFuego() > getEnemigo().getBlindaje()) {
            getEnemigo().setHP(getEnemigo().getHP()-(flota.getPoderFuego()-getEnemigo().getBlindaje()));
        }
        return getEnemigo().getHP() < 1;
    }

    @Override
    public int minNodo() {
        return 1+Math.min(getHijoIzquierdo().minNodo(), getHijoDerecho().minNodo());
    }

    @Override
    public String nodoActual() {
        return "(" + getNombre() + " Battle, " + getHijoIzquierdo().nodoActual()  + ", " + getHijoDerecho().nodoActual() +")";
    }
}
