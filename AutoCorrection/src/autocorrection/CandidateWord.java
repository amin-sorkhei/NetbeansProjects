package autocorrection;

public class CandidateWord {

    private final String typo, TypoStatus, CandidateWord;
    private final char OriginalCharacter, TypoCharacter;

    public CandidateWord() {
        this.typo = null;
        this.TypoStatus = null;
        this.CandidateWord = null;
        this.OriginalCharacter = 0;
        this.TypoCharacter = 0;
    }

    public CandidateWord(String typo, String TypoStatus, String CandidateWord, char OriginalCharacter, char TypoCharacter) {
        this.typo = typo;
        this.TypoStatus = TypoStatus;
        this.CandidateWord = CandidateWord;
        this.OriginalCharacter = OriginalCharacter;
        this.TypoCharacter = TypoCharacter;
    }

    public String getCandidateWord() {
        return CandidateWord;
    }

    public char getOriginalCharacter() {
        return OriginalCharacter;
    }

    public String getTypo() {
        return typo;
    }

    @Override
    public String toString() {
        if (TypoStatus.equals("del")) {
            return "The wrong word is : " + this.getTypo() + " The corrected form is " + this.getCandidateWord() + "\n"+
                    "Error Type : " + TypoStatus + "\n"
                    + "deleted character [c(p)] is : " + String.valueOf(OriginalCharacter) + "\n"
                    + "the preciding character [c(p-1)] is " + String.valueOf(TypoCharacter) + "\n"
                    + "I will look corpus for " + String.valueOf(TypoCharacter) + String.valueOf(OriginalCharacter) + "\n";
        }
        if (TypoStatus.equals("ins")) {
            return "The wrong word is : " + this.getTypo() + " The corrected form is " + this.getCandidateWord() + "\n"+
                    "Error Type : " + TypoStatus + "\n"
                    + "inserted character [t(p)] is : " + String.valueOf(OriginalCharacter) + "\n"
                    + "the preciding character [c(p-1)] is " + String.valueOf(TypoCharacter) + "\n"
                    + "I will look corpus for " + String.valueOf(TypoCharacter) + "\n";
        }
        if (TypoStatus.equals("sub")) {
            return "The wrong word is : " + this.getTypo() + " The corrected form is " + this.getCandidateWord() + "\n"+
                    "Error Type : " + TypoStatus + "\n"
                    + "substituted character [t(p)] is : " + String.valueOf(OriginalCharacter) + "\n"
                    + "the wrong character [c(p)] is " + String.valueOf(TypoCharacter) + "\n"
                    + "I will look corpus for " + String.valueOf(TypoCharacter) + "\n";
        }
        if (TypoStatus.equals("trans")) {
            return "The wrong word is :  " + this.getTypo() + " The corrected form is " + this.getCandidateWord() + "\n"+
                    "Error Type : " + TypoStatus + "\n"
                    + "[c(p)] is : " + String.valueOf(TypoCharacter) + "\n"
                    + "[c(p+1)] is " + String.valueOf(OriginalCharacter) + "\n"
                    + "I will look corpus for " + String.valueOf(TypoCharacter) + String.valueOf(OriginalCharacter) + "\n";
        }
    return "";
    }

}
