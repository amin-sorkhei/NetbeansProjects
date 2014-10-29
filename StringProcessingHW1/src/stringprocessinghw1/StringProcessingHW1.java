package stringprocessinghw1;

public class StringProcessingHW1 {

    public static void main(String[] args) throws InterruptedException {
        //RecursiveFib RF = new RecursiveFib();
        //System.out.println(RF.fib(100));

        DPFib fib = new DPFib();
        System.out.println(fib.FIB(43));
        TimedRecursiveFib trfib = new TimedRecursiveFib(5);
    }
}
