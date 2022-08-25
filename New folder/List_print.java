import java.util.ArrayList;
import java.util.Scanner;

public class List_print {

    public static void prompt_to_enter() {
            Scanner scanner=new Scanner(System.in);
            System.out.println("\nPress Enter key two times to continue...");
            try
            {
                System.in.read();
                scanner.nextLine();
            }
            catch(Exception ignored)
            {}
    }
    public static void print ( ArrayList<Movie>List) {
        for (Movie movies:List) {
            movies.print_info();

        }
        prompt_to_enter();

    }

}
