import java.io.File;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args){


        // TODO: 3/2/2020
        // create command line interface to create inverted index (give file path)

        // Create cmd line interface for querying an object

        // Create Cmd line interface for recalling object

        // read in Saved Inverted index Object
        InvertedIndex i = new InvertedIndex();
        i.readFromFile("serializedInvertedIndex.txt");
        i.dumpInvertedIndex();
        return;

        //Read in Saved StopWordHashTable and Dump Contents
//        StopWordHashTable swht = new StopWordHashTable();
//        swht.readInStopWordObject("stopWordHashSetObject.txt");
//        swht.dumpStopWords();

    }

}
