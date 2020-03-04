import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BuildStopWordHashTable {
    public void BuildStopWordHashTable(/* */) {
    }




//    public static void main(String[] args){
    public void build(/* */) {
//         Read from file
        File inputFile = new File("src/main/resources/stopwords_en.txt");
        StopWordHashTable swht = new StopWordHashTable();
        try {
            Scanner s = new Scanner(inputFile);
            while(s.hasNext()) {
//                System.out.println(s.next());
                swht.add(s.next());
            }
        }
        catch (Exception e){
            System.out.println("From BuildStopWordHashTable " + e);
        }

        // ---Debug---
//        swht.dumpStopWords();

        // Export object to a textfile
        swht.writeOutStopWordObject();



    }
}
