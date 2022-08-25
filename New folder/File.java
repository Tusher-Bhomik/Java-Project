import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
     static List<Movie> MovieList = new ArrayList<>();

    private static final String INPUT_FILE_NAME = "movies.txt";
    private static final String OUTPUT_FILE_NAME = "movies.txt";

    public static void write()throws Exception
    {
    BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
            for (Movie movie : MovieList) {
        bw.write(movie.getName() + "," + movie.getReleaseYear() + "," + movie.getGenre1() + "," +
                movie.getGenre2() + "," + movie.getGenre3() + "," + movie.getRunningTime() + "," + movie.getProductionCompany()
                + "," + movie.getBudget() + "," + movie.getRevenue());
        bw.write(System.lineSeparator());
    }
            bw.close();
}


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            Movie m = new Movie(line);
            MovieList.add(m);
        }
        br.close();
        Main_menu menu = new Main_menu();

        Main_menu menu1 =new Main_menu();

        menu.Main_menu_a((ArrayList<Movie>) MovieList);


        }
}

