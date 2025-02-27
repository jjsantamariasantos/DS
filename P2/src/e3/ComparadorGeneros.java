package e3;

import java.util.Comparator;

public class ComparadorGeneros implements Comparator<Artist> {
    @Override
    public int compare(Artist a1, Artist a2) {
        return Integer.compare(a1.getGeneros().size(), a2.getGeneros().size());
    }
}
