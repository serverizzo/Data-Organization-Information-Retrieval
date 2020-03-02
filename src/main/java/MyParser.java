import java.io.File;
import java.util.Scanner;

public class MyParser {

    File dir;

    MyParser(){   }

    MyParser(File dir){
        this.dir = dir;
    }

    public void setNewDir(File dir){
        this.dir = dir;
    }

    public void parse(){
        boolean enteredScriptTag = false;
        boolean enteredStyleTag = false;
        boolean enteredTag = false;
        boolean enteredHTMLComment = false;
        boolean enteredJsComment = false;
        boolean enteredStyleTag = false;
        int count = 0;

        try {
            for (File curr : dir.listFiles()) {
                // Connect to file
                File input = new File(curr.toString());
//                System.out.println(curr);
                // Begin reading from file
                Scanner s = new Scanner(input);
                while(s.hasNext()){
                    //get the considered string
                    String considering = s.next();

                    // CSS FILTERTING -- needs to be first to avoid html filtering next
                    if(considering.matches("<style>")) enteredStyleTag = true;
                    if(considering.matches("</style>")){
                        enteredStyleTag = false;
                        continue;
                    }
                    if(enteredStyleTag) continue;


                    //HTML FILTERING
                    // tags
                    // if we are inside a tag (i.e. if we start with a '<'), set flag to continue
                    if(considering.matches("^<.*")) enteredTag = true;
                    if(considering.matches(".*>$")) {
                        enteredTag = false;
                        // we just ended the tag. Everything considered is not plain text.
                        continue;
                    }
                    if(enteredTag) continue;

                    // html filtering
                    if(considering.matches("^<!--.*")) enteredHTMLComment = true;
                    if(considering.matches(".*-->$")) {
                        enteredHTMLComment = false;
                        // we just ended the comment. Everything considered is not plain text.
                        continue;
                    }
                    if(enteredHTMLComment) continue;






                    //JAVASCRIPT FILTERING
                    // If the the line is Javascript (i.e. it ends in a ';') continue.
                    if (considering.matches(".*;$")) continue;
                    // If the considering line is a Javascript/CSS comment;
                    if (considering.matches("^//*.*")) enteredJsComment = true;
                    if (considering.matches(".*/*/$")){
                        // we just exited the comment, everything we just considered was a comment. continue.
                        enteredJsComment = false;
                        continue;
                    }
                    if (enteredJsComment) continue;


//                    // Filter misc characters
                    if(considering.matches("\\W+")) continue;
//                     remove any words that start with, or have a . in the middle of their word.
                    if(considering.matches(".*[.].+")) continue;

                    System.out.println(considering);
                    count += 1;
                }
                s.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        // w beginning tags 6786 -> w.o. 1246
        // without js, 1172
        // without JS comments 394
        System.out.println(count);

    }



    public static void main(String[] args){


        MyParser x = new MyParser(new File("src/main/resources/"));
        x.parse();

//        String z = "</script>";
//        System.out.println(z.matches("^<.*"));
//        System.out.println(z.matches(".*>$"));

//        String z = "hhg */";
//        System.out.println(z.matches("^//*.*"));
//        System.out.println(z.matches(".*/*/$"));

//        String z = "asdfasdf.asdfasdf";
//        System.out.println(z.matches(".*[.].+"));
//        System.out.println(z.matches("\\w*"));


//          TODO:
//          <!--
//          -->


    }



}
