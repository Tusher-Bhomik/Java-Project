import java.util.Objects;

public class Movie {
    private String Name;
    private String ReleaseYear;
    private String Genre1;
    private String Genre2;
    private String Genre3;
    private String RunningTime;
    private String ProductionCompany;
    private String Budget;
    private String Revenue;
    public void setName(String name) {
        Name = name;
    }

    public void setReleaseYear(String releaseYear) {
        ReleaseYear = releaseYear;
    }

    public void setGenre1(String genre1) {
        Genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        Genre2 = genre2;
    }

    public void setGenre3(String genre3) {
        Genre3 = genre3;
    }

    public void setRunningTime(String runningTime) {
        RunningTime = runningTime;
    }

    public void setProductionCompany(String productionCompany) {
        ProductionCompany = productionCompany;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }

    public void setRevenue(String revenue) {
        Revenue = revenue;
    }
    public Movie(String info) {
        String out[] = info.split(",");
        setName(out[0]);
        setReleaseYear(out[1]);
        setGenre1(out[2]);
        setGenre2(out[3]);
        setGenre3(out[4]);
        setRunningTime(out[5]);
        setProductionCompany(out[6]);
        setBudget(out[7]);
        setRevenue(out[8]);
    }
    public Movie()
    {
        //default cons
    }
    public String getName() {
        return Name;
    }

    public String getReleaseYear() {

        return ReleaseYear;
    }
    public int get_year() {
        return Integer.parseInt(ReleaseYear);
    }
    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public String getGenre3() {
        return Genre3;
    }

    public String getRunningTime() {
        return RunningTime;
    }

    public String getProductionCompany() {
        return ProductionCompany;
    }

    public String getBudget() {
        return Budget;
    }

    public String getRevenue() {
        return Revenue;
    }

    public int get_Revenue() {
        return Integer.parseInt(Revenue);
    }
    public int get_runtime()
    {
        return Integer.parseInt(RunningTime);
    }
    public int get_profit() {
        return ( Integer.parseInt(Revenue)- Integer.parseInt(Budget));
    }
    public void print_info() {

        System.out.println("TITLE: " + Name + "\n"
                + "Release Year: " + ReleaseYear);
        if (!Objects.equals(Genre1, "")) System.out.print("Genre: " + Genre1);
        if (!Objects.equals(Genre2, "")) System.out.print(", " + Genre2);
        if (!Objects.equals(Genre3, "")) System.out.print(", " + Genre3);
        System.out.println("");
        System.out.println("RUNNING Time: " + RunningTime + "\n" + "Production Compnay: "
                + ProductionCompany + "\n"
                + "Budget: " + Budget + "\n" + "Revenue: " + Revenue + "\n\n");
    }
}
