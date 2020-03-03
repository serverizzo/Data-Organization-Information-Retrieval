//import jdk.vm.ci.meta.Value;
import opennlp.tools.stemmer.PorterStemmer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class BuildInvertedIndex {

    BuildInvertedIndex(File dir) throws IOException {


//    public static void main(String[] args){
//        File dir =  new File("src/main/resources/");
        InvertedIndex invertedIdx = new InvertedIndex();
        MyParser p = new MyParser();
        int positionCount;
        String allWords;
        PorterStemmer ps = new PorterStemmer();

        // Read all html files in 'dir' directory
        for (File curr: dir.listFiles()){

            // Get the next HTML doc
            File input = new File(curr.toString());
            // get only the text from the html --Needs to be Refined--
            allWords = p.parseToString(curr);
            // Reset count to zero
            positionCount = 0;

            // ---Debuging---
            // System.out.println("All words from html: " +  allWords);

            // Split allWords string into an array. Each word is an element in the new array.
            String[] allWordsArray = allWords.split( " ");
            for( String keyWord: allWordsArray ){

                // Stem keyWord
                keyWord = ps.stem(keyWord);
                // Create Value object
                ValueObject val = new ValueObject(curr.toString(), positionCount);
                // Add key and value to inverted index
                invertedIdx.add(keyWord,val);
                positionCount += 1;
            }
        }

        invertedIdx.saveToFile();
//        System.out.println("object serialized");
    }
}
