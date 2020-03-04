import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class StopWordHashTable {
    Set<String> stopWords = new HashSet<String>();

    public void add(String s){
        stopWords.add(s);
    }

    // Detects if word is in stopwords
    public boolean contains(String word){
        return this.stopWords.contains(word);
    }

    public void dumpStopWords(){
        Object[] arr = this.stopWords.toArray();
        for(Object o : arr){
            System.out.println(o);
        }
    }


    public void readInStopWordObject(String path){
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.stopWords = (HashSet<String>)ois.readObject();
        }
        catch(Exception e){
            System.out.println("From InvertedIndex: " + e);
        }
    }

    public void writeOutStopWordObject(){
        try {
            FileOutputStream fos = new FileOutputStream("stopWordHashSetObject.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(stopWords);
            oos.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }






}
