package e2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Personajes {
    private String nombre;
    private int vida;
    private int fuerza;
    private int mana;
    private ArrayDeque<ObjetosAtaque> listaAtaque;
    private ArrayList<ObjetosDefensa> listaDefensa;

    public Personajes(String nombre, int vida, int fuerza, int mana, ArrayDeque<ObjetosAtaque> listaAtaque, ArrayList<ObjetosDefensa> listaDefensa) throws IllegalArgumentException{
        if(nombre != null && vida >= 0 && vida <=20 && fuerza >=1 && fuerza <= 10 && mana >= 0 && mana <= 10 &&
                listaAtaque != null && listaAtaque.size() <=5 && listaDefensa != null && listaDefensa.size() <=5) {
            this.nombre = nombre;
            this.vida = vida;
            this.fuerza = fuerza;
            this.mana = mana;
            this.listaAtaque = listaAtaque;
            this.listaDefensa = listaDefensa;
        } else{
            throw new IllegalArgumentException("No se han cumplido con las especificaciones de creacion del personaje.");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) throws IllegalArgumentException{
        if(vida >= 0){
            this.vida = vida;
        } else {
            throw new IllegalArgumentException("No se cumplen las condiciones");
        }

    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) throws IllegalArgumentException {
        if (fuerza <= 10 && fuerza > 1) {
            this.fuerza = fuerza;
        }else {
            throw new IllegalArgumentException("Valor invalido");
        }

    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {

        if (mana <= 10 && mana > 0) {
            this.mana = mana;
        }else {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    public ArrayDeque<ObjetosAtaque> getListaAtaque() {
        return listaAtaque;
    }

    public void setListaAtaque(ArrayDeque<ObjetosAtaque> listaAtaqueN) throws IllegalArgumentException{

        if(listaAtaqueN != null && listaAtaqueN.size() <= 5  && !listaAtaqueN.isEmpty()){
            this.listaAtaque = listaAtaqueN;
        } else{
            throw new IllegalArgumentException("Tamano invalido");
        }

    }

    public ArrayList<ObjetosDefensa> getListaDefensa() {return listaDefensa;
    }

    public void setListaDefensa(ArrayList<ObjetosDefensa> listaDefensaN) throws IllegalArgumentException {

        if(listaDefensaN != null && listaDefensaN.size() <= 5  && !listaDefensaN.isEmpty()){
            this.listaDefensa = listaDefensaN;
        } else{
            throw new IllegalArgumentException("Tamano invalido");
        }
    }
    public int ataque(Personajes atacante, Personajes defensor) {
        ObjetosAtaque objetoAtacante = atacante.getListaAtaque().getFirst();


        if (atacante.getListaAtaque() != null && !atacante.getListaAtaque().isEmpty()) {
            ArrayDeque<ObjetosAtaque> listaAtaque = new ArrayDeque<>(atacante.getListaAtaque());


            if (atacante.getMana() < objetoAtacante.getManaMinimo()) {
                listaAtaque.removeFirst();
                atacante.setListaAtaque(listaAtaque);
                return 0;
            } else {
                int ataque = objetoAtacante.ataque(), defensa = 0, vida = defensor.getVida(), dano;


                if (defensor.getListaDefensa() != null && !defensor.getListaDefensa().isEmpty()) {
                    for (ObjetosDefensa objetoDefensa : defensor.getListaDefensa()) {
                        if (defensor.getFuerza() >= objetoDefensa.getFuerzaMinima()) {
                            defensa = defensa + objetoDefensa.getDefensa();
                        }
                    }
                }
                dano = ataque - defensa;
                if (dano < 0) {
                    dano = 0;
                }
                vida = vida - dano;
                if(vida < 0){
                    vida = 0;
                }
                defensor.setVida(vida);
                listaAtaque.removeFirst();
                if(objetoAtacante.getUsos() > 0){
                    listaAtaque.addFirst(objetoAtacante);
                }
                atacante.setListaAtaque(listaAtaque);
                return dano;
            }
        } else {
            return 0;
        }
    }
}
