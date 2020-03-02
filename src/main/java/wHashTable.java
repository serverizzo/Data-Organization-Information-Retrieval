import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class wHashTable {
    public static void main(String[] args) throws IOException {

//        ValueObject val = new ValueObject("testString", 0);
//        val.print();

        // Create Hashtable
        Map<String, ValueObject> ht = new Hashtable<String, ValueObject>();

        // Create path to file directory
        File dir =  new File("src/main/resources/");

        ArrayList<String> wordsInList = new ArrayList<String>();
        int count;

        // Read all html files in 'dir' directory
        for (File curr: dir.listFiles()){
            File input = new File(curr.toString());
            // Parse text
            Document page = Jsoup.parse(input, "UTF-8");
            // get only text
            String allWords = page.text();

            count = 0;
            // Split allWords string into an array. Each word is an element in the new array.
            for( String keyWord: allWords.split(" ")){
                // use each word in array as an index,
                ValueObject val = new ValueObject(curr.toString(), count);
                ht.put(keyWord, val);
                count += 1;
            }
        }

        Object[] sortedKeys = ht.keySet().toArray();
        Arrays.sort(sortedKeys);
        for( Object e: sortedKeys ){
            System.out.println(e);
        }


    }
}
