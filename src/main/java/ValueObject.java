import java.io.Serializable;

public class ValueObject implements Serializable {

//    String documentFoundIn;
//    Integer position;
    String[] val = new String[2];

    ValueObject(String documentFoundIn, Integer position){
//        this.documentFoundIn = documentFoundIn;
//        this.position = position;
        this.val = new String[]{documentFoundIn, position.toString()};
    }
//
//    public int getPosition(){
//        return position;
//    }
//
//    public String getDocumentFoundIn(){
//        return documentFoundIn;
//    }

    public void print(){
        System.out.println(val[0] + "  " + val[1]);
    }

    public String toString(){ return val[0] + " " + val[1];}


}
