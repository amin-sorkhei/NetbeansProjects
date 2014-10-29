package spproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Comparator;

public class wordReader {

    private final BufferedReader reader;
    private final FileReader input;
    private final HashMap<String, AtomicInteger> words;
    List<Entry<String, AtomicInteger>> list;

    public wordReader() throws FileNotFoundException, IOException {
        input = new FileReader("test2.txt");
        reader = new BufferedReader(input);
        words = new HashMap<>();
        this.readWords();
        
    }

    private void readWords() throws IOException {
        String line;
        String[] wordArray;
        while ((line = reader.readLine()) != null) { 
            //System.out.println(line);
            wordArray = line.split("\\s+");
            //System.out.println(Arrays.toString(wordArray));//////
            for (String str : wordArray) {
                if (str.equals(""))
                    continue;
                
                if (words.keySet().contains(str)) {
                    words.get(str).incrementAndGet();
                } else {
                    words.put(str, new AtomicInteger(1));
                }
            }
        }
        System.out.println(words.keySet().size());
        this.sortValue();
    }

    public void sortValue() {
       list = new ArrayList<>(words.entrySet());
        Collections.sort(list, new Comparator<Entry<String, AtomicInteger>>() {

            @Override
            public int compare(Entry<String, AtomicInteger> o1, Entry<String, AtomicInteger> o2) {
                int temp = o1.getValue().intValue() - o2.getValue().intValue();
                if (temp < 0) {
                    return +1;
                } else if (temp > 0) {
                    return -1;
                }
                return 0;
            }
        });

    }

    @Override
    public String toString() {
        return list.toString();
    }

}
