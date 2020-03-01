import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class helloworld {

    public static void main(String[] args) throws IOException {

        // Read html file
        File input = new File("src/main/resources/howToMakeElectricity.html");

        // Parse html file
        Document page = Jsoup.parse(input, "UTF-8");;
//        try {
//             page =
//        }
//        catch(IOException e){
//            System.out.println("Exception hit:  " + e);
//        }

        // Document.text() grabs plaintext from html file and puts into a string
        String allWords = page.text();

        ArrayList<String> wordsInList = new ArrayList<String>();

        // Split allWords string into an array. Each word is an element in the new array.
        for( String e: allWords.split(" ")){
            wordsInList.add(e);
        }

        // show words in array
//        for (String e: wordsInList){
//            System.out.println(e);
//        }

        //Show length -- currently 806
        System.out.println(wordsInList.size());



    }
}
