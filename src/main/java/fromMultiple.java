import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class fromMultiple {

    public static void main(String[] args) throws IOException {

        // Create path to file directory
        File dir =  new File("src/main/resources/");

        // Shows something weird
//        System.out.println(dir.listFiles());

        // Show all files in path dir
//        for (File curr: dir.listFiles()){
//            System.out.println(curr);
//        }

        ArrayList<String> wordsInList = new ArrayList<String>();

        // Read html file
        for (File curr: dir.listFiles()){
           File input = new File(curr.toString());
           // Parse text
           Document page = Jsoup.parse(input, "UTF-8");
           // get only text
           String allWords = page.text();

            // Split allWords string into an array. Each word is an element in the new array.
            for( String e: allWords.split(" ")){
               wordsInList.add(e);
           }
        }

        //Show length -- currently now currently 1668
        System.out.println(wordsInList.size());



    }
}
