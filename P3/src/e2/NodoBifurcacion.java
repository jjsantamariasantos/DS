package e2;

public abstract class NodoBifurcacion extends Nodo{

    // Caracteristicas

    private final Nodo hijoIzquierdo;
    private final Nodo hijoDerecho;

    // Constructor

    public NodoBifurcacion(String nombre, Nodo hijoIzquierdo, Nodo hijoDerecho) {
        super(nombre);
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    // Getters

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    // Metodos

    public abstract Nodo obtenerSiguienteNodo(Flota flota);
    public abstract boolean incursion(Flota flota);
    public abstract int minNodo();
    public abstract String nodoActual();
}
