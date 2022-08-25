import java.util.Comparator;

public class Revenue_comparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return o2.get_Revenue()- o1.get_Revenue();
    }
}