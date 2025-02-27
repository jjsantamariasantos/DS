package e3;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Release {
    private final String identificador;
    private String titulo;
    private String artistaPrincipal;
    private final List<Track> listaDeReproduccion;

    public Release(String identificador)throws IllegalArgumentException{
        if(identificador == null){
            throw new IllegalArgumentException();
        }
        this.identificador  = identificador;
        this.listaDeReproduccion = new ArrayList<>();
    }
    public void setTitle(String titulo) throws IllegalArgumentException{
        if(titulo == null){
            throw new IllegalArgumentException();
        }
        this.titulo = titulo;
    }

    public void setArtist(String artistaPrincipal)throws IllegalArgumentException{
        if(artistaPrincipal == null){
            throw new IllegalArgumentException();
        }
        this.artistaPrincipal = artistaPrincipal;
    }

    public void addTrack(Track lista)throws IllegalArgumentException{
        if(lista == null){
            throw new IllegalArgumentException();
        }
        listaDeReproduccion.add(lista);
    }

    private @NotNull Set<String> compararGrabacion(){
        List<String> grabacion = new ArrayList<>();


        for(Track lista : listaDeReproduccion){
            grabacion.add(lista.grabacion());
        }
        return new HashSet<>(grabacion);
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Release release = (Release) objeto;
        return Objects.equals(compararGrabacion(), release.compararGrabacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(compararGrabacion());
    }

    @Override
    public String toString() {
        return "Release{" +
                "identificador='" + identificador + '\'' +
                ", titulo='" + titulo + '\'' +
                ", artistaPrincipal='" + artistaPrincipal + '\'' +
                ", listaDeReproduccion=" + listaDeReproduccion +
                '}';
    }

}
