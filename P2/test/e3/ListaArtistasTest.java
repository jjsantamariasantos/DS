package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaArtistasTest {
    Artist artist1;
    Artist artist2;
    Artist artist3;
    ListaArtistas listaArtistas;
    @BeforeEach
    void Setup(){
        artist1 = new Artist("Adele", "UK", 4.4, Arrays.asList("Pop", "Soul", "Blue-eyed Soul", "Neo Soul"));
        artist2 = new Artist("Taylor Swift", "USA", 4.1, Arrays.asList("Pop", "Country", "Country Pop", "Contemporary Country", "Pop Rock"));
        artist3 = new Artist("Melendi", "SPN", 0.0, Arrays.asList("Flamenco","Pop Rock","Rumba"));
        List<Artist> artistList = Arrays.asList(artist1, artist2, artist3);
        listaArtistas = new ListaArtistas(artistList);
    }

    @Test
    public void testOrdenarPorId() {
        listaArtistas.ordenarPorId();
        assertEquals(artist1, listaArtistas.getArtistas().get(0));
        assertEquals(artist3, listaArtistas.getArtistas().get(1));
        assertEquals(artist2, listaArtistas.getArtistas().get(2));
    }

    @Test
    public void testOrdenarPorValoracion() {
        listaArtistas.ordenarPorValoracion();
        assertEquals(artist3, listaArtistas.getArtistas().get(0));
        assertEquals(artist2, listaArtistas.getArtistas().get(1));
        assertEquals(artist1, listaArtistas.getArtistas().get(2));
    }
    @Test
    public void testOrdenarPorPais(){
        listaArtistas.ordenarPorPais();
        assertEquals(artist3, listaArtistas.getArtistas().get(0));
        assertEquals(artist1, listaArtistas.getArtistas().get(1));
        assertEquals(artist2, listaArtistas.getArtistas().get(2));
    }
    @Test
    public void testOrdenarPorEclepticismo(){
        listaArtistas.ordenarPorGeneros();
        assertEquals(artist3, listaArtistas.getArtistas().get(0));
        assertEquals(artist1, listaArtistas.getArtistas().get(1));
        assertEquals(artist2, listaArtistas.getArtistas().get(2));
    }

}