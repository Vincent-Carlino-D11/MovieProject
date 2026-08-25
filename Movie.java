public class Movie {
    private String title;
    private String actor;
    private int year;
    private String directors;

    private static String RESET = "\u001B[0m";
    private static String RED = "\u001B[31m";
    private static String GREEN = "\u001B[32m";
    private static String BLUE = "\u001B[34m";
    private static String YELLOW = "\u001B[33m";
    private static String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        
    }

    public Movie(String t, String a, int y, String d){
        title = t;
        actor = a;
        year = y;
        directors = d;
    }

    public String getTitle(){
        return title;
    }

    public String getActor(){
        return actor;
    }

    public int getYear(){
        return year;
    }

    public String getDirector(){
        return directors;
    }

    public String toString(){
        return (BLUE + getTitle() + RESET + " " + getActor() + " " + YELLOW + getYear() + " " + RESET + getDirector());
    }
}
