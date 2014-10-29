package autocorrection;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class AutoCorrection {
    public static void main(String[] args) throws FileNotFoundException {
        WordStuff ws = new WordStuff();
        HashMap word = new HashMap<>();
        word = ws.ReadFile();
        System.out.println(word.keySet().size());
        ws.CandidateGenerator("acress");
        
    }
    
}
