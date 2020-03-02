import opennlp.tools.stemmer.PorterStemmer;
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

        Map<String, ValueObject> ht = new Hashtable<String, ValueObject>();
        MyParser p = new MyParser();
        // Path to all htmlfiles
        File dir =  new File("src/main/resources/");
        ArrayList<String> wordsInList = new ArrayList<String>();
        int positionCount;
        String allWords;
        PorterStemmer ps = new PorterStemmer();

        // Read all html files in 'dir' directory
        for (File curr: dir.listFiles()){
            File input = new File(curr.toString());
            // get only the text from the html --Needs to be Refined--
            allWords = p.parseToString(curr);
            positionCount = 0;
            System.out.println("All words from html: " +  allWords);
            // Split allWords string into an array. Each word is an element in the new array.
            String[] allWordsArray = allWords.split( " ");
            for( String keyWord: allWordsArray){

//                System.out.println("from HashTable: " + keyWord);

                // Stem word



                //Split the String into an array, each value is a word, catalog it and its index number.
                keyWord = ps.stem(keyWord);
                ValueObject val = new ValueObject(curr.toString(), positionCount);
                // TODO Currently we are overwriting each put, we need to append to each.
                ht.put(keyWord, val);
                positionCount += 1;
            }
        }

        Object[] sortedKeys = ht.keySet().toArray();
        Arrays.sort(sortedKeys);
        for( Object e: sortedKeys ){
            System.out.println(e.toString() + " " + ht.get(e).toString());
        }


    }
}
