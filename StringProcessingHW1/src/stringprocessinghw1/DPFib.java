package stringprocessinghw1;

import java.util.ArrayList;

public class DPFib {

    private ArrayList<Integer> result;

    public DPFib() {
        result = new ArrayList<>();
        result.add(0);
        result.add(1);
    }

    public int FIB(int fibNumber) {
        if (fibNumber == 0 || fibNumber == 1) {
            return fibNumber;
        }
        for (int i = 2; i <= fibNumber; i++) {
            result.add(result.get(i - 1) + result.get(i - 2));
        }
        return result.get(fibNumber);

    }

}
