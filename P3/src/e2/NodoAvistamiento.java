package e2;

public class NodoAvistamiento extends NodoBifurcacion{

    // Caracteristicas

    private final int distancia;

    // Constructor

    public NodoAvistamiento(String nombre, Nodo hijoIzq, Nodo hijoDer, int distancia) {
        super(nombre, hijoIzq, hijoDer);
        this.distancia = distancia;
    }

    // Getter

    public int getDistancia() {
        return distancia;
    }

    // Metodos

    @Override
    public Nodo obtenerSiguienteNodo(Flota flota) {
        if(incursion(flota)) {
            return getHijoIzquierdo();
        }
        else {
            return getHijoDerecho();
        }
    }

    @Override
    public boolean incursion(Flota flota) {
        return flota.getLineaVision() >= getDistancia();
    }

    @Override
    public int minNodo() {
        return 1+Math.min(getHijoIzquierdo().minNodo(), getHijoDerecho().minNodo());
    }

    @Override
    public String nodoActual() {
        return "(" + getNombre() + " WaypointSpotting, "+ getHijoIzquierdo().nodoActual()  +
                ", " + getHijoDerecho().nodoActual() + ")";
    }
}
