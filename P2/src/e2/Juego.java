package e2;

public class Juego {
    Personajes personaje1;
    Personajes personaje2;
    int turnos;

    public Juego(Personajes personaje1, Personajes personaje2, int turnos) throws  IllegalArgumentException{
        if(turnos > 0 && personaje2 != null && personaje1 != null){
            this.personaje1 = personaje1;
            this.personaje2 = personaje2;
            this.turnos = turnos;
        } else{
            throw new IllegalArgumentException("No se ha establecido un numero de turnos valido");
        }

    }

    public int simularAtaque(){
        int dano =personaje1.ataque(getPersonaje1(), getPersonaje2());
        System.out.println(getPersonaje1() + "Ha hecho " + dano + "puntos de dano a " + getPersonaje2());
        return dano;
    }
    public Personajes combate () throws IllegalArgumentException{
        int tiempo;
        int turnostemp = getTurnos();
        Personajes atacante, defensor, ganador = null;
        if((turnos % 2) == 0){
            atacante = personaje1;
            defensor = personaje2;
        } else{
            atacante = personaje2;
            defensor = personaje1;
        }
        for (tiempo = 1; tiempo <= turnostemp; tiempo ++){
            int dano;
            dano = atacante.ataque(atacante, defensor);
            System.out.println(atacante.getNombre() + " ha hecho " + dano + " puntos de dano a " + defensor.getNombre());
            dano = defensor.ataque(defensor, atacante);
            System.out.println(defensor.getNombre() + " ha hecho " + dano + " puntos de dano a " + atacante.getNombre());
            if(personaje1.getVida() == 0){
                ganador = personaje2;
                break;
            } else if(personaje2.getVida()== 0){
                ganador = personaje1;
                break;
            }
        }
        return ganador;
    }

    public Personajes getPersonaje1() {
        return personaje1;
    }

    public void setPersonaje1(Personajes personaje1) {
        this.personaje1 = personaje1;
    }

    public Personajes getPersonaje2() {
        return personaje2;
    }

    public void setPersonaje2(Personajes personaje2) {
        this.personaje2 = personaje2;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }
}
