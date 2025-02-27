package e2;

public abstract class NodoRutaFija extends Nodo {

    // Caracteristicas

    private final Nodo hijo;

    // Constructor

    public NodoRutaFija(String nombre, Nodo hijo) {
        super(nombre);
        this.hijo = hijo;
    }

    // Getter

    public Nodo getHijo() {
        return hijo;
    }

    // Metodos

    public abstract Nodo obtenerSiguienteNodo(Flota flota);
    public abstract boolean incursion(Flota flota);

    public abstract int minNodo();
    public abstract String nodoActual();
}
