import java.util.*;
import java.util.HashMap;

public class Main_menu {

    static Scanner in = new Scanner(System.in);

    public void Main_menu_1(ArrayList<Movie> List) throws Exception {

        System.out.println("""
                Movie Searching Options:

                1) By Movie Title
                2) By Release Year\s
                3) By Genre\s
                4) By Production Company
                5) By Running Time\s
                6) Top 10 Movies
                7) Back to Main Menu

                """);
        System.out.print("Please choose a option :");
        List<Movie> search_List = new ArrayList<>();
        String a = in.nextLine();
        switch ((a)) {
            case "1" -> search_List = Search_By_Movie_name(List);
            case "2" -> search_List = Search_by_Releasing_year(List);
            case "3" -> search_List = Search_By_Genre(List);
            case "4" -> search_List = Search_By_Production_Company(List);
            case "5" -> search_List = Search_By_Running_time(List);
            case "6" -> search_List = Search_Top_10_Movies(List);
            case "7" -> Main_menu_a(List);
            default -> System.out.println("Choose A valid option");
        }
        if (!a.equals("7")) {
            List_print.print((ArrayList<Movie>) search_List);
        }
        Main_menu_1(List);
    }

    public  List<Movie> Search_By_Movie_name(ArrayList<Movie> List) {
        System.out.print("Enter Movie Title: ");
        String str = in.nextLine();
        int flag = 0;
        List<Movie> new_List = new ArrayList<>();
        for (Movie movie : List) {
            if (str.equalsIgnoreCase(movie.getName())) {
                new_List.add((movie));
                System.out.println("Found");
                flag = 1;
                break;
            }
        }
        if (flag == 0) System.out.println("Not Found having this title");
        return new_List;
    }

    public  List<Movie> Search_by_Releasing_year(ArrayList<Movie> List) {

        System.out.print("Enter Releasing Year: ");
        String str = in.nextLine();
        System.out.println();
        int flag = 0;
        List<Movie> new_List = new ArrayList<>();
        for (Movie movie : List) {
            if (str.equalsIgnoreCase(movie.getReleaseYear())) {
                new_List.add(movie);
                flag = 1;

            }

        }
        if (flag == 0) System.out.println("No movie Found in the database released in the year " + str);
        return new_List;

    }

    public List<Movie> Search_By_Genre(ArrayList<Movie> List) {
        System.out.print("Enter Movie Genre of your wishlist: ");
        String str = in.nextLine();
        int flag = 0;
        List<Movie> new_List = new ArrayList<>();
        for (Movie movie : List) {
            if (str.equalsIgnoreCase(movie.getGenre1()) ||
                    str.equalsIgnoreCase(movie.getGenre2()) ||
                    str.equalsIgnoreCase(movie.getGenre3())) {

                new_List.add(movie);
                flag = 1;
            }

        }
        if (flag == 0) System.out.print("No movie Found Under this Genre");
        return new_List;
    }

    public List<Movie> Search_By_Production_Company(ArrayList<Movie> List) {
        System.out.print("Enter the production  company name :");
        String str = in.nextLine();
        System.out.println();
        int flag = 0;
        List<Movie> new_List = new ArrayList<>();
        for (Movie movie : List) {
            if (str.equalsIgnoreCase(movie.getProductionCompany())) {
                new_List.add(movie);
                flag = 1;

            }

        }
        if (flag == 0) System.out.println("Not found Any movie under this production company");
        return new_List;


    }

    public List<Movie> Search_By_Running_time(ArrayList<Movie> List) {
        System.out.print("Enter the running time Range :");
        int a = in.nextInt();
        int b = in.nextInt();
        if (a > b) a += (b - (b = a));

        System.out.println();
        int flag = 0;
        List<Movie> new_List = new ArrayList<>();
        for (Movie movie : List) {
            if (movie.get_runtime() <= b && movie.get_runtime() >= a) {
                new_List.add(movie);
                flag = 1;
            }

        }
        if (flag == 0) System.out.println("Not found");
        return new_List;

    }

    public List<Movie> Search_Top_10_Movies(ArrayList<Movie> List) {
        System.out.print("Here is your top 10 Movies: \n\n");

        List.sort(new Profit_Comparator());
        List<Movie> new_List = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            new_List.add(List.get(i));
        }
        return new_List;

    }

    public void Main_menu_2(ArrayList<Movie> List) throws Exception {
        System.out.println("""
                Production Company Searching Options:
                1) Most Recent Movies\s
                2) Movies with the Maximum Revenue
                3) Total Profit
                4) List of Production Companies and the Count of their Produced Movies\s
                5) Back to Main Menu""");
        System.out.println();
        System.out.print("Please choose a option :");
        String a = in.nextLine();
        List<Movie> search_List = new ArrayList<>();
        switch ((a)) {
            case "1" -> search_List = Most_Recent_Movies(List);
            case "2" -> search_List = Movies_with_the_Maximum_Revenue(List);
            case "3" -> Total_Profit(List);
            case "4" -> List_of_Production_Companies_and_the_Count_of_their_Produced_Movies(List);
            case "5" -> Main_menu_a(List);
            default -> System.out.print("Choose A valid option");
        }
        if (a.equals("1") || a.equals("2")) {
            List_print.print((ArrayList<Movie>) search_List);
        }
        Main_menu_2(List);
    }


    public List<Movie> Most_Recent_Movies(ArrayList<Movie> List) {
        System.out.print("Write a production company Name : ");
        String str = in.nextLine();
        System.out.println();
        int flag = 0;

        List<Movie> MovieList = new ArrayList<>();
        List<Movie> update_list = new ArrayList<>();

        for (Movie value : List) {
            if (str.equalsIgnoreCase(value.getProductionCompany())) {
                MovieList.add(value);
                flag = 1;
            }
        }
        if (flag == 0) System.out.println("No such production company with this name .\n");
        else {
            MovieList.sort(new year_comparator());


            for (Movie movie : MovieList) {
                if (movie.getReleaseYear().equals(MovieList.get(0).getReleaseYear())) {
                    update_list.add(movie);
                }
            }
        }
        return update_list;
    }


    public List<Movie> Movies_with_the_Maximum_Revenue(ArrayList<Movie> List) {
        System.out.println();
        System.out.print("Write a production company Name :");

        String str = in.nextLine();
        System.out.println();
        int flag = 0;
        List<Movie> update_List = new ArrayList<>();
        List<Movie> MovieList = new ArrayList<>();
        for (Movie value : List) {
            if (str.equalsIgnoreCase(value.getProductionCompany())) {
                MovieList.add(value);
                flag = 1;

            }
        }
        if (flag == 0) System.out.println("No such production company with this name .\n");
        else {
            MovieList.sort(new Revenue_comparator());

            for (Movie movie : MovieList) {
                if (MovieList.get(0).get_Revenue() == movie.get_Revenue()) {
                    update_List.add(movie);
                }
            }
        }
        return update_List;

    }

    public void Total_Profit(ArrayList<Movie> List) {
        System.out.println();
        System.out.print("Write a production company Name :");
        String str = in.nextLine();
        System.out.println();
        int flag = 0;
        long total = 0;
        for (Movie movie : List) {
            if (str.equalsIgnoreCase(movie.getProductionCompany())) {
                flag = 1;
                total += movie.get_profit();
            }
        }
        if (flag == 0) System.out.println("No such production company with this name .\n");
        else {
            System.out.println("Total profit :" + total);
        }
        List_print.prompt_to_enter();
    }

    public  void List_of_Production_Companies_and_the_Count_of_their_Produced_Movies(ArrayList<Movie> List) {
        HashMap<String, Integer> no_of_produced_movie = new HashMap<>();

        no_of_produced_movie.put(List.get(0).getProductionCompany(), 1);
        for (Movie movie : List) {
            if (no_of_produced_movie.containsKey(movie.getProductionCompany()))
                no_of_produced_movie.put(movie.getProductionCompany(),
                        no_of_produced_movie.get(movie.getProductionCompany()) + 1);
            else {
                no_of_produced_movie.put(movie.getProductionCompany(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : no_of_produced_movie.entrySet()) {
            System.out.println();
            System.out.println("Production Company Name: " + entry.getKey() + "," + "No of Movies: " + entry.getValue());
        }
        List_print.prompt_to_enter();
    }

    public  void Main_menu_3(ArrayList<Movie> List) throws Exception {
        Scanner new_in = new Scanner(System.in);
        System.out.println("Add new movie to the Data Base__\n");
        System.out.print("How many Movies info you want to add :");
        int n = in.nextInt();
        String name;
        int num, flag = 0;
        for (int i = 0; i < n; i++) {
            Movie movie = new Movie();
            System.out.print("Enter Movie name: ");
            name = new_in.nextLine();

            for (Movie value : List) {
                if (name.equalsIgnoreCase(value.getName())) {
                    System.out.println("Already In the Movie database");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                movie.setName(name);

                System.out.print("Enter The releasing year of the movie: ");
                movie.setReleaseYear(new_in.nextLine());
                System.out.print("How many Genre you want to add(Not more than Three):  ");
                num = new_in.nextInt();
                movie.setGenre1("");
                movie.setGenre2("");
                movie.setGenre3("");

                if (num >= 1) {
                    movie.setGenre1(new_in.nextLine());
                    movie.setGenre1(new_in.nextLine());
                }
                if (num >= 2)
                    movie.setGenre2(new_in.nextLine());
                if (num == 3)
                    movie.setGenre3(new_in.nextLine());

                System.out.print("Enter the Running Time of the Movie :");
                movie.setRunningTime(new_in.nextLine());
                System.out.print("Enter the production company name :");
                movie.setProductionCompany(new_in.nextLine());
                System.out.print("Enter the Budget of the movie: ");
                movie.setBudget(new_in.nextLine());
                System.out.print("Enter The revenue Of the movie :");
                movie.setRevenue(new_in.nextLine());
                List.add(movie);
                System.out.println("\nMovie Successfully added to the Movie Database");
            }
        }
        List_print.prompt_to_enter();
        Main_menu_a(List);

    }

    public void Main_menu_a(ArrayList<Movie> List) throws Exception {

        System.out.println("""
                Main Manu:
                1) Search Movies
                2) Search Production Companies
                3) Add Movie
                4) Exit System""");
        System.out.println("\n\n__________________________________________");
        String n;
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose An Option: ");
        n = sc.nextLine();
        System.out.println("\n\n");

        switch (n) {
            case "1" -> Main_menu_1(List);
            case "2" -> Main_menu_2(List);
            case "3" -> Main_menu_3(List);
            case "4" -> {
                File.write();
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice! Please make a valid choice.");
                Main_menu_a(List);
            }
        }

    }
}

