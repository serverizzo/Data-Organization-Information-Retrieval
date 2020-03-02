/*
    Parses html to string given a file path


 */




import opennlp.tools.stemmer.PorterStemmer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MyParser {

    File dir;

    MyParser(){   }

    MyParser(File dir){this.dir = dir;}

    public void setNewDir(File dir){this.dir = dir;}

    public String parseToString(File inputPath){
        boolean enteredScriptTag = false;
        boolean enteredTag = false;
        boolean enteredHTMLComment = false;
        boolean enteredJsComment = false;
        boolean enteredStyleTag = false;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        try {
            // Connect to file
            File input = new File(inputPath.toString());
            // Begin reading from file
            Scanner s = new Scanner(input);
            // Read all words from string, filtering out anything that is not plaintext.
            while(s.hasNext()){
                // Get the next word
                String considering = s.next();

                if (considering.matches(".*\\W.*")){
                    continue;
                }

//                    // CSS FILTERTING -- needs to be first to avoid html filtering next
//                    if(considering.matches("<style>")) enteredStyleTag = true;
//                    if(considering.matches("</style>")){
//                        enteredStyleTag = false;
//                        continue;
//                    }
//                    if(enteredStyleTag) continue;


//                //HTML FILTERING
//                // tags
//                // if we are inside a tag (i.e. if we start with a '<'), set flag to continue
//                if(considering.matches("^<.*")) enteredTag = true;
//                if(considering.matches(".*>$")) {
//                    enteredTag = false;
//                    // we just ended the tag. Everything considered is not plain text.
//                    continue;
//                }
//                if(enteredTag) continue;
//
//                // html filtering
//                if(considering.matches("^<!--.*")) enteredHTMLComment = true;
//                if(considering.matches(".*-->$")) {
//                    enteredHTMLComment = false;
//                    // we just ended the comment. Everything considered is not plain text.
//                    continue;
//                }
//                if(enteredHTMLComment) continue;
//
//                //JAVASCRIPT FILTERING
//                // If the the line is Javascript (i.e. it ends in a ';') continue.
//                if (considering.matches(".*;$")) continue;
//                // If the considering line is a Javascript/CSS comment;
//                if (considering.matches("^//*.*")) enteredJsComment = true;
//                if (considering.matches(".*/*/$")){
//                    // we just exited the comment, everything we just considered was a comment. continue.
//                    enteredJsComment = false;
//                    continue;
//                }
//                if (enteredJsComment) continue;
//
//
//                // Filter misc characters
//                if(considering.matches("^\\W+$")) continue;
//                // remove any words that start with, or have a . in the middle of their word.
//                if(considering.matches(".+[.].+")) continue;


                // Append new word to string builder
                sb.append(considering + " ");

//                    System.out.println(considering + " ");
                count += 1;
            }
            s.close();
    }

    catch (Exception e){
        System.out.println("From MyParser, Exception caught: " + e);
    }

    // ---Performance----
    // w beginning tags 6786 -> w.o. 1246
    // without js, 1172
    // without JS comments 394
    // without style tag
    // System.out.println(count);

    return sb.toString();
    }


//      ---------Testing--------
//
//    public static void main(String[] args){
//
//
//        MyParser x = new MyParser(new File("src/main/resources/"));
////        System.out.println(x.parseToString());
//
////        String z = "</script>";
////        System.out.println(z.matches("^<.*"));
////        System.out.println(z.matches(".*>$"));
//
////        String z = "hhg */";
////        System.out.println(z.matches("^//*.*"));
////        System.out.println(z.matches(".*/*/$"));
//
////        String z = "asdfasdf.asdfasdf";
////        System.out.println(z.matches(".*[.].+"));
////        System.out.println(z.matches("\\w*"));
//
//
//
//
//    }



}
