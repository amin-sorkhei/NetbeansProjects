import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordReader {

    private final File fileReader;
    private final Scanner reader;
    private final FileWriter fileWriter;
    private final WordStuff ws;
    private ArrayList<CandidateWord> container;

    public WordReader(String address) throws FileNotFoundException, IOException {
        fileWriter = new FileWriter("//home//amin//Desktop//result.txt");
        fileReader = new File(address);
        reader = new Scanner(fileReader);
        ws = new WordStuff();
    }

    public void result() throws IOException {
        while (reader.hasNextLine()) {
            container = ws.CandidateGenerator(reader.nextLine());
            
            if (container.size() >= 3){
            fileWriter.write("--------------------NEW WORD CANDIDATE--------------------\n");
                for (CandidateWord cw : container) {
                    fileWriter.write("*****************\n");
                    fileWriter.write(cw.toString());
                    System.out.println("\n");
                    fileWriter.write("*****************\n");
                }
            }
            System.out.println("\n");

        }
    fileWriter.close();
    }

}
