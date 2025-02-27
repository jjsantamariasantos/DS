package e2;


public class NodoTormentaMarina extends NodoRutaFija{

    // Caracteristicas

    private final int fuerzaTormenta;

    // Constructor

    public NodoTormentaMarina(String nombre, Nodo hijo, int fuerzaTormenta) {
        super(nombre, hijo);
        this.fuerzaTormenta = fuerzaTormenta;
    }

    // Getter

    public int getFuerzaTormenta() {
        return fuerzaTormenta;
    }

    @Override
    public Nodo obtenerSiguienteNodo(Flota flota) {
        if(incursion(flota)) {
            return getHijo();
        }
        return this;
    }

    @Override
    public boolean incursion(Flota flota) {
        if(flota.getLineaVision() < getFuerzaTormenta()) {
            flota.setHP(flota.getHP()-10);
        }
        return flota.getHP() >= 1;
    }

    @Override
    public int minNodo() {
        return 1+getHijo().minNodo();
    }

    @Override
    public String nodoActual() {
        return "(" + getNombre() + " Maelstrom, " + getHijo().nodoActual() + ")";
    }
}
