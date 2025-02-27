package e3;

import java.util.Objects;

public record Track(String cara, String grabacion, String artistaPrincipal, String titulo, int duracion) {


    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Track track = (Track) objeto;
        return Objects.equals(grabacion, track.grabacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grabacion);
    }

    @Override
    public String toString() {
        return "Track{" +
                "cara='" + cara + '\'' +
                ", grabacion='" + grabacion + '\'' +
                ", artistaPrincipal='" + artistaPrincipal + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
