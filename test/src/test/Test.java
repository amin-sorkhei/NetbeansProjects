
package test;
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("aple");
       sb.insert(2, "*");
        System.out.println(sb.toString());
        System.out.println(sb.length());
    }
    
}
