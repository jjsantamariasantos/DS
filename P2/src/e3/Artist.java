package e3;

import java.util.List;

public class Artist implements Comparable<Artist>{
    private String id;
    private String pais;
    private double valoracion;
    private List<String> generos;

    public Artist(String nombre, String pais, double valoracion, List<String> generos) throws IllegalArgumentException{
        if(nombre != null && pais != null && valoracion >= 0 && valoracion <= 5 && generos != null && !generos.isEmpty()){
            this.id = nombre;
            this.pais = pais;
            this.valoracion = valoracion;
            this.generos = generos;
        } else {
            throw new IllegalArgumentException("No se cumplen las condiciones de creacion");
        }
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public int compareTo(Artist artista) {
        return getId().compareTo(artista.getId());
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + getId() + '\'' +
                ", pais='" + getPais() + '\'' +
                ", valoracion=" + getValoracion() +
                ", numero de generos=" + getGeneros().size()+
                '}';
    }
}
