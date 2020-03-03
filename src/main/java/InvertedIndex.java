import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class InvertedIndex {

    Map<String, ArrayList<ValueObject>> ht = new Hashtable<String, ArrayList<ValueObject>>();

    public void readFromFile(String path){

        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ht = (Hashtable<String, ArrayList<ValueObject>>)ois.readObject();
        }
        catch(Exception e){
            System.out.println("From InvertedIndex: " + e);
        }

    }

    public void saveToFile(){
        try {
            FileOutputStream fos = new FileOutputStream("serializedInvertedIndex.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ht);
            oos.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void add(String keyWord, ValueObject val){
        if(ht.containsKey(keyWord)){
            ht.get(keyWord).add(val);
        }
        else{
            ht.put(keyWord, new ArrayList<ValueObject>());
            ht.get(keyWord).add(val);
        }
    }

    public void dumpInvertedIndex(){
        Object[] sortedKeys = ht.keySet().toArray();
        Arrays.sort(sortedKeys);
        for( Object e: sortedKeys ){
            System.out.print(e.toString());
            for (ValueObject x: ht.get(e)){
                System.out.print(" " + x.toString());
            }
            System.out.println();
        }
    }



}
