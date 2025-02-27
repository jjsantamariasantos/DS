package e2;

public class NodoFin extends Nodo {

    //Constructor

    public NodoFin(String nombre) {
        super(nombre);
    }

    // Metodos

    @Override
    public Nodo obtenerSiguienteNodo(Flota flota) {
        return null;
    }

    @Override
    public boolean incursion(Flota flota) {
        return false;
    }

    @Override
    public int minNodo() {
        return 1;
    }

    @Override
    public String nodoActual() {
        return "(" + getNombre()+" End)";
    }
}
