import java.util.Scanner;
import java.lang.Math;

public class MaxAndMin {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	int n1 = in.nextInt();
    	int n2 = in.nextInt();
    	int n3 = in.nextInt();
    	double d1 = in.nextDouble();
    	double d2 = in.nextDouble();

    	int max = maxOf3(n1,n2,n3);
    	System.out.println("Maximum: " + max);
    	
    	System.out.println("Minimum: " + minOf3(n1,n2,n3));

    	System.out.println("Double Divison: " + bonus(d1, d2));
    	System.out.println("Integer Division: " + (n1/n2));
    }

    public static int maxOf3(int r, int s, int t) {
    	int a = Math.max(r, Math.max(s, t));
    	return a;
    }
    
    public static int minOf3(int r, int s, int t) {
    	int b = Math.min(r, Math.min(s, t));
    	return b;
    }
    
    public static int bonus(double r, double s){
    	int a = (int) Math.round(r);
    	int b = (int) Math.round(s);

    	return a/b;
    }
}