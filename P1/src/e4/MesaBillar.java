package e4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MesaBillar {
    private  List<BolaBillar> mesa;
    private List<BolaBillar> cajetin;
    private boolean partidaEnJuego;

    public MesaBillar(){
        this.mesa = new ArrayList<>();
        this.cajetin = new ArrayList<>();
        this.partidaEnJuego = Boolean.FALSE;


        anadirBolasCajetin();
    }

    public void anadirBolasCajetin(){
        cajetin.addAll(Arrays.asList(BolaBillar.values()));
    }

    public void anadirBolasMesa(){
        mesa.addAll(Arrays.asList(BolaBillar.values()));
    }

    public void iniciarPartida(){
        cajetin.clear();
        mesa.clear();
        partidaEnJuego = Boolean.TRUE;


        anadirBolasMesa();
    }

    public void meterBola(BolaBillar bola) throws IllegalArgumentException{
        if(!esPartidaIniciada() || !bolasMesa().contains(bola)){
            throw new IllegalArgumentException();
        }
        if(bola ==BolaBillar.BOLA8){
            cajetin.clear();
            mesa.clear();
            partidaEnJuego = Boolean.FALSE;
        } else if((bola.getNumero() <= 7 && bola.getNumero() >= 1) || (bola.getNumero() > 7 && bola.getNumero() <= 15)){
            mesa.remove(bola);
            cajetin.add(bola);
        }
    }

    public List<BolaBillar> bolasMesa(){
        return new ArrayList<>(mesa);
    }

    public List<BolaBillar> bolasCajetin(){
        return new ArrayList<>(cajetin);
    }

    public boolean esPartidaIniciada(){
        return partidaEnJuego;
    }

    public String obtenerGanador(){
        StringBuilder ganador = new StringBuilder();
        int bolasLisas = 0, bolasRayadas = 0;
        for(BolaBillar bola : bolasMesa()){
            if(bola.getTipo().equals("LISA")){
                if(bola != BolaBillar.BLANCA && bola != BolaBillar.BOLA8) {
                    bolasLisas++;
                }

            }
            else{
                bolasRayadas++;
            }
        }
        if(bolasLisas == bolasRayadas){
            return "EMPATE";
        } else if(bolasLisas < bolasRayadas){
            ganador.append("LISAS");
        } else{
            ganador.append("RAYADAS");
        }
        return ganador.toString();
    }
}
