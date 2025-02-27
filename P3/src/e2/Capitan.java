package e2;

public class Capitan {
    private final Flota flota;
    private final Nodo mapa;

    // Constructor

    public Capitan(Flota flota, Nodo mapa) {
        this.flota = flota;
        this.mapa = mapa;
    }

    // Getters y setter

    public Flota getFlota() {
        return flota;
    }

    public Nodo getMapa() {
        return mapa;
    }

    // Metodos

    public String simularIncursion() {
        StringBuilder str = new StringBuilder();
        boolean condicionIncursion = false;
        Nodo mapa = getMapa();
        while((mapa.getClass() != NodoFin.class) && (getFlota().getHP() >= 1)) {
            mapa = mapa.obtenerSiguienteNodo(getFlota());
        }
        if(getFlota().getHP() >= 1) {
            condicionIncursion = true;
        }
        str.append("Sortie Result:").append("\n")
                .append(condicionIncursion ? "\tSUCCESS\n" : "\tFAIL\n")
                .append("\t").append("Last Visited Node: ").append(mapa.getNombre()).append("\n")
                .append("\t").append("Final HP: ").append(getFlota().getHP()).append("\n");
        return str.toString();
    }

    public String numeroMinimoDeNodos() {
        return "Smallest Node Count to End: "+getMapa().minNodo();
    }

    public String representarMapa() {
        return getMapa().nodoActual();
    }

    public String informacionflota(){
        return getFlota().infoFlota();
    }

}
