package e2;

public abstract class Nodo {

    // Caracteristicas
    private final String nombre;

    // Constructor

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    // Getter

    public String getNombre() {
        return nombre;
    }

    // Metodos

    public abstract Nodo obtenerSiguienteNodo(Flota flota);
    public abstract boolean incursion(Flota flota);
    public abstract int minNodo();
    public abstract String nodoActual();

}
