import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDB {
    public static void main(String[] args){
        readMoviesintoAL("test.txt");
    }


    public static ArrayList<Movie> readMoviesintoAL(String filename){
    // public static ArrayList<String> readMoviesintoAL(String filename){
        ArrayList<Movie> ret = new ArrayList<Movie>();
        // ArrayList<String> ret = new ArrayList<String>();
       
        try{
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        
        while(true){
            String fullString = sc.nextLine();
            System.out.println("PARSING: " + fullString);
            int splitter = fullString.indexOf(" | ");
            String title = fullString.substring(0, splitter);
            System.out.println(title);

            fullString = fullString.substring(splitter+3);
            splitter = fullString.indexOf(" | ");
            String leadActor = fullString.substring(0, splitter);
            System.out.println(leadActor);

            fullString = fullString.substring(splitter+3);
            splitter = fullString.indexOf(" | ");
            String ReleaseYear = fullString.substring(0, splitter);
            System.out.println(ReleaseYear);

            String director = fullString.substring(splitter+3);
            System.out.println(director);
            
            int releaseYear = Integer.parseInt(ReleaseYear);

            System.out.println("ADDING MOVIE: " + title + leadActor + releaseYear + director);
            ret.add(new Movie(title, leadActor, releaseYear, director));
            //ret.add(title + leadActor + releaseYear + director);
            if(!sc.hasNext()){
                break;
            }
        }
        sc.close();
        } catch(FileNotFoundException e){}
        return ret;
    }
      
}
