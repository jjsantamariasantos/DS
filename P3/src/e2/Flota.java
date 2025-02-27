package e2;

public class Flota {

    // Caracteristicas
    private final String nombre;
    private int HP;
    private final int blindaje;
    private final int poderFuego;
    private final int antiaereos;
    private final int lineaVision;

    // Constructor

    public Flota(   String nombre, int HP, int blindaje, int poderAtaque, int antiaereos, int lineaVision) {
        this.nombre = nombre;
        this.HP = HP;
        this.blindaje = blindaje;
        this.poderFuego = poderAtaque;
        this.antiaereos = antiaereos;
        this.lineaVision = lineaVision;
    }

    // Getters y setter

    public String getNombre(){
        return nombre;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getBlindaje() {
        return blindaje;
    }

    public int getPoderFuego() {
        return poderFuego;
    }

    public int getAntiaereos() {
        return antiaereos;
    }

    public int getLineaVision() {
        return lineaVision;
    }

    // Metodos

    public String infoFlota(){
        return "Flota " + getNombre() + "\n" + "HP " +
                getHP() + "\n" + "Blindaje " + getBlindaje() +
                "\n" + "Poder de Fuego " + getPoderFuego() + "\n" +
                "Antiaereo " + getAntiaereos() + "\n" + "Linea de Vision " +
                getLineaVision() + "\n";
    }
}
