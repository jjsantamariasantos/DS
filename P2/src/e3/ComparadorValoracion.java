package e3;

import java.util.Comparator;

public class ComparadorValoracion implements Comparator<Artist> {
    @Override
    public int compare(Artist a1, Artist a2){
        return Double.compare(a1.getValoracion(), a2.getValoracion());
    }
}
