import java.util.Scanner;
import java.Math;

public class MaxAndMin {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	int n1 = in.nextInt();
    	int n2 = in.nextInt();
    	int n3 = in.nextInt();
    	
    	int max = maxOf3(n1,n2,n3);
    	System.out.println("Maximum: " + max);
    	
    	System.out.println("Minimum: " + minOf3(n1,n2,n3));
    }

    public static int maxOf3(int r, int s, int t) {
    	int a = Math.max(r, Math.max(s, t));
    	return a;
    }
    
    public static int minOf3(int r, int s, int t) {
    	int b = Math.min(r, Math.min(s, t));
    	return b;
    }
    
}
