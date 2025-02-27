package e3;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListaArtistas {
    private List<Artist> artistas;

    public ListaArtistas(List<Artist> artistas) throws IllegalArgumentException{
        if(artistas != null && !artistas.isEmpty()){
            this.artistas = artistas;
        } else{
            throw new IllegalArgumentException("No se cumplen las condiciones de creacion");
        }

    }

    public List<Artist> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artist> artistas) {
        this.artistas = artistas;
    }
    public void ordenarPorId(){
        Collections.sort(getArtistas(), new ComparadorId());

    }

    public void ordenarPorPais(){
        Collections.sort(getArtistas(), new ComparadorPais());
    }
    public void ordenarPorValoracion(){
        Collections.sort(getArtistas(), new ComparadorValoracion());
    }
    public void ordenarPorGeneros(){
        Collections.sort(getArtistas(), new ComparadorGeneros());
    }

}
