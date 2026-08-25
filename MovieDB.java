import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDB {

    
    private static String RESET = "\u001B[0m";
    private static String RED = "\u001B[31m";
    private static String GREEN = "\u001B[32m";
    private static String BLUE = "\u001B[34m";
    private static String YELLOW = "\u001B[33m";
    private static String PURPLE = "\u001B[35m";


    public static void main(String[] args){
        System.out.println(RESET);
        ArrayList<Movie> testList = readMoviesIntoAL("movie.txt");
        System.out.println();
        System.out.println("LOGGIN' COMPLETED MOVIES");
        System.out.println();
        //for(Movie m : testList){
        //    System.out.println(m);
        //}
        printPretty(testList);
    }


    public static ArrayList<Movie> readMoviesIntoAL(String filename){
        ArrayList<Movie> ret = new ArrayList<Movie>();
       
        try{
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        
        while(true){
            String fullString = sc.nextLine();
            System.out.println("PARSING: " + fullString);
            int splitter = fullString.indexOf(" | ");
            String title = fullString.substring(0, splitter);

            fullString = fullString.substring(splitter+3);
            splitter = fullString.indexOf(" | ");
            String leadActor = fullString.substring(0, splitter);

            fullString = fullString.substring(splitter+3);
            splitter = fullString.indexOf(" | ");
            String ReleaseYear = fullString.substring(0, splitter);

            String director = fullString.substring(splitter+3);
            
            int releaseYear = Integer.parseInt(ReleaseYear);

            System.out.println("ADDING MOVIE: " + title + leadActor + releaseYear + director);
            ret.add(new Movie(title, leadActor, releaseYear, director));
            if(!sc.hasNext()){
                break;
            }
        }
        sc.close();
        } catch(FileNotFoundException e){}
        return ret;
    }

    public static void printPretty(ArrayList<Movie> al){
        int longName = 0;
        int longActor = 0;
        int longDirector = 0;
        for(Movie m : al){
            if(m.getTitle().length() > longName){
                longName = m.getTitle().length();
            }
            if(m.getActor().length() > longActor){
                longActor = m.getActor().length();
            }
            if(m.getDirector().length() > longDirector){
                longDirector = m.getDirector().length();
            }
        }
        for(Movie m: al){
            System.out.print(m.getTitle());
            for(int i = m.getTitle().length(); i <= longName; i++){
                System.out.print(" ");
            }
            System.out.print(BLUE + "| " + RESET);
            System.out.print(m.getActor());
            for(int i = m.getActor().length(); i <= longActor; i++){
                System.out.print(" ");
            }
            System.out.print(BLUE + "| " + RESET);
            System.out.print(m.getYear());
            System.out.print(BLUE + " | " + RESET);
            System.out.print(m.getDirector());
            for(int i = m.getDirector().length(); i <= longDirector; i++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
