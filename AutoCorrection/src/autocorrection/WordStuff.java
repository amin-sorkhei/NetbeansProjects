package autocorrection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class WordStuff {

    private final File file;
    private final Scanner scan;
    private final HashMap words;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final ArrayList<CandidateWord> CandidateList;
    private Set vocabulary;
    private StringBuilder word;

    public WordStuff() throws FileNotFoundException {
        file = new File("words.txt");
        scan = new Scanner(file);
        words = new HashMap<>();
        CandidateList = new ArrayList<>();
    }

    public HashMap ReadFile() {
        while (scan.hasNextLine()) {
            words.put(scan.nextLine(), 0);
        }
        vocabulary = words.keySet();
        return words;
    }

    public void CandidateGenerator(String input) {
        insertion(input);
        deletion(input);
        substitution(input);
        Transposition(input);
        System.out.println("Number of words: "+CandidateList.size());
        System.out.println(CandidateList.toString());
    }

    public void Transposition(String input) {
        word = new StringBuilder(input);
        String temp;
        char ch1, ch2;
        for (int i = 0; i < word.length() - 1; i++) {
            ch1 = word.charAt(i);// the firs candidate to do transposition
            ch2 = word.charAt(i + 1); // the second candidate to do transposition
            word.delete(i, i + 2);// deletes the characters which are going to contribute to transposition
            word.insert(i, String.valueOf(ch2) + String.valueOf(ch1));//forms the new word
            temp = word.toString();
            if (vocabulary.contains(temp)) {
                CandidateWord cw = new CandidateWord(input, "trans", temp, ch2, ch1);
                CandidateList.add(cw);
            }
            word.delete(i, i + 2);// deletes the tranposed characters
            word.insert(i, String.valueOf(ch1) + String.valueOf(ch2));// form the original word for next itteration
        }
        //System.out.println("Transposition results" + CandidateList.toString());
    }

    public void substitution(String input) {
        word = new StringBuilder(input);
        String temp;
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);// contains the character which is going to be replaced
            word.deleteCharAt(i);// deletes the character which is going to be replaced
            for (int j = 0; j < alphabet.length(); j++) {
                word.insert(i, alphabet.charAt(j));// inserts the new character to form the new word
                temp = word.toString();
                if (vocabulary.contains(temp)) {
                    CandidateWord cw =  new CandidateWord(input, "sub", temp, alphabet.charAt(j), ch);
                    CandidateList.add(cw);
                }
                word.deleteCharAt(i);// deletes recently added character
            }
            word.insert(i, ch);// return the original character to its place and forms the original word for next character substitution
        }
        //System.out.println("Substitution results" + CandidateList.toString());
    }

    public void insertion(String input) {
        word = new StringBuilder(input);
        char ch;// to hold the deleted characte so the original composition of the input retrieved by replacing this character
        String temp;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            temp = word.deleteCharAt(i).toString();
            if (vocabulary.contains(temp)) {
                CandidateWord cw = new CandidateWord(input, "ins", temp, input.charAt(i), ch);
                CandidateList.add(cw);
            }
            word.insert(i, ch);
        }
    }

    public void deletion(String input) {

        word = new StringBuilder(input);// creates a StringBuilder of the input
        String temp;// a temp String to hold the result
        for (int i = 0; i < alphabet.length(); i++) {
            for (int j = 0; j <= word.length(); j++) {
                temp = word.insert(j, alphabet.charAt(i)).toString();
                if (vocabulary.contains(temp)) {
                    CandidateWord cw = new CandidateWord(input, "del", temp, alphabet.charAt(i), word.charAt(j));
                    CandidateList.add(cw);
                }
                word.deleteCharAt(j); // to delete the added character and access the original string once more

            }
        }
    }

}
