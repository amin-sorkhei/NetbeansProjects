package stringprocessinghw1;

public class TimedRecursiveFib {

    private long start, end;
    private RecursiveFib FIB;
    private int result, timeLimit;

    public TimedRecursiveFib(int time) {
        timeLimit = time;
        FIB = new RecursiveFib();
        int fibNumber = 0;
        while (fibNumber >= 0) {
            start = System.nanoTime() / (int) Math.pow(10, 9);
            result = FIB.fib(fibNumber);
            end = System.nanoTime() / (int) Math.pow(10, 9);
            if (end - start > timeLimit) {
                System.out.println("can not go further");
                System.out.println("last number computed + " + (fibNumber - 1));
                System.exit(0);
            }
            System.out.println("fib(" + fibNumber + ") = " + result + "in " + (end - start) + " seconds");
            fibNumber++;
        }

    }

}
