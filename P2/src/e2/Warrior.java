package e2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Warrior extends Personajes {
    public Warrior(String nombre, int vida, int fuerza, int mana, ArrayDeque<ObjetosAtaque> listaAtaque, ArrayList<ObjetosDefensa> listaDefensa) throws IllegalArgumentException{
        super(nombre, vida, fuerza, mana, listaAtaque, listaDefensa);
    }

    @Override
    public int ataque(Personajes atacante, Personajes defensor) throws IllegalArgumentException {
        return super.ataque(atacante, defensor);
    }
}
