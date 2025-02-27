package e3;

import java.util.Comparator;

public class ComparadorId implements Comparator<Artist> {
    @Override
    public int compare(Artist a1, Artist a2) {
        return a1.getId().compareTo(a2.getId());
    }
}
