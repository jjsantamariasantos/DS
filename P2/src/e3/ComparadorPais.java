package e3;

import java.util.Comparator;

public class ComparadorPais implements Comparator<Artist> {
    @Override
    public int compare(Artist a1, Artist a2) {
        return a1.getPais().compareTo(a2.getPais());
    }
}
