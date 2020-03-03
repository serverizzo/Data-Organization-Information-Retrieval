import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class InvertedIndex {

    Map<String, ArrayList<ValueObject>> ht = new Hashtable<String, ArrayList<ValueObject>>();

    public void add(String keyWord, ValueObject val){
        if(ht.containsKey(keyWord)){
            ht.get(keyWord).add(val);
        }
        else{
            ht.put(keyWord, new ArrayList<ValueObject>());
            ht.get(keyWord).add(val);
        }
    }

    public void dumpInvertedIndex(Map<String, ArrayList<ValueObject>> ht){
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
