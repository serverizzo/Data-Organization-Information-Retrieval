import java.io.File;
import java.io.IOException;

public class SearchEngine {
    public static void main(String[] args){

        File corpusDir;
        File NameOfIndexFile;
        File NameOfStopListFile;
        File QueryFile;
        File ResultsFile;

        String arg;
        for (int idx = 0; idx < args.length; idx++){
            arg = args[idx];
            System.out.println("idx is " + idx);
            if (args[0].equals("-help") || args[0].equals("-h") || args[0].equals("-?")){
                System.out.println("-CorpusDir [PathOfDir]");
                System.out.println("Build Inverted Index: -b (Must be done before Querying)");
                System.out.println("Build StopWordHashTable: -bswht (Must be done before Building the Inverted Index)");
                System.out.println("Query : -q [Query]");
                System.out.println("Dump Inverted Index : -di");
                System.out.println("Dump Stop Word List : -dsw");
            }

            if (arg.equals("-CorpusDir")) {
                corpusDir = new File(args[++idx]);
                System.out.println(corpusDir);
            }

            else if (arg.equals("-InvertedIndex")){
                NameOfStopListFile = new File(args[++idx]);
                System.out.println(NameOfStopListFile);
            }

            else if (arg.equals("-StopList")){
                NameOfIndexFile = new File(args[++idx]);
                System.out.println(NameOfIndexFile);
            }

            else if (arg.equals("-Queries")){
                QueryFile = new File(args[++idx]);
                System.out.println(QueryFile);
            }

            else if (arg.equals("-Results")){
                ResultsFile = new File(args[++idx]);
                System.out.println(ResultsFile);
            }

            else if(arg.equals("-b")) {
                try {
                    BuildInvertedIndex bii = new BuildInvertedIndex(new File("src/main/resources/corpus"), "stopWordHashSetObject.txt");
                } catch (Exception e) {
                    System.out.println("From MainClass: " + e);
                }
                System.out.println("Inverted Index created and outputted to textfile");
            }

            else if(arg.equals("-bswht")) {
                BuildStopWordHashTable bswht = new BuildStopWordHashTable();
                bswht.build();
                System.out.println("Stopword hashtable build written to textfile");
            }

            else if(arg.equals("-q")){
                InvertedIndex i = new InvertedIndex();
//                i.readFromFile("C:\\Users\\Edward\\IdeaProjects\\phase1\\serializedInvertedIndex.txt");
                i.readFromFile("..\\..\\serializedInvertedIndex.txt");
                i.query(args[1]);
            }

            else if(arg.equals("-di")) {
                InvertedIndex i = new InvertedIndex();
                if (args.length == 2 )
                    i.readFromFile(args[0]);
                else
//                   i.readFromFile("C:\\Users\\Edward\\IdeaProjects\\phase1\\serializedInvertedIndex.txt");
                    i.readFromFile("..\\..\\serializedInvertedIndex.txt");
                i.dumpInvertedIndex();
            }


            else  if(arg.equals("-dsw")) {
                //Read in Saved StopWordHashTable and Dump Contents
                StopWordHashTable swht = new StopWordHashTable();
                swht.readInStopWordObject("..\\..\\stopWordHashSetObject.txt");
                swht.dumpStopWords();
            }

            else{
                System.out.println("not recognized");
            }

        }




        // TODO: 3/2/2020
        // create command line interface to create inverted index (give file path)
//        try{
//           BuildInvertedIndex bii = new BuildInvertedIndex(new File("src/main/resources/corpus"), "stopWordHashSetObject.txt");
//        }
//        catch (Exception e){
//            System.out.println("From MainClass: " + e);
//        }
//        System.out.println("Inverted Index created and outputted to textfile");


        // Create cmd line interface for querying an object

        // Create Cmd line interface for recalling object

        // read in Saved Inverted index Object
//        InvertedIndex i = new InvertedIndex();
//        i.readFromFile("serializedInvertedIndex.txt");
//        i.dumpInvertedIndex();
//        return;

        //Read in Saved StopWordHashTable and Dump Contents
//        StopWordHashTable swht = new StopWordHashTable();
//        swht.readInStopWordObject("stopWordHashSetObject.txt");
//        swht.dumpStopWords();

    }

}
