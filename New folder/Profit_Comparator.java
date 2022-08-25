import java.util.Comparator;

public class Profit_Comparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return o2.get_profit()- o1.get_profit();
    }
}