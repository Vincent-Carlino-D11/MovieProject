import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDB {
    public static void main(String[] args){
        ArrayList<Movie> testList = readMoviesIntoAL("movie.txt");
        System.out.println();
        System.out.println("LOGGIN' COMPLETED MOVIES");
        System.out.println();
        for(Movie m : testList){
            System.out.println(m);
        }
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
}
