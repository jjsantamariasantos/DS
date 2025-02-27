package e2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Wizard extends Personajes {
    public Wizard(String nombre, int vida, int fuerza, int mana, ArrayDeque<ObjetosAtaque> listaAtaque, ArrayList<ObjetosDefensa> listaDefensa) {
        super(nombre, vida, fuerza, mana, listaAtaque, listaDefensa);
    }

    @Override
    public int ataque(Personajes atacante, Personajes defensor) {
        return super.ataque(atacante, defensor);
    }
}
