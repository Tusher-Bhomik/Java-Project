import java.util.Comparator;

public class year_comparator implements Comparator<Movie>{

        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.get_year()- o1.get_year();
        }
    }
