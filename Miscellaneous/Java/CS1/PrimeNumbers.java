import java.util.*;
import java.lang.Math;

public class PrimeNumbers{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("Please enter an integer or 0000 to exit to bonus: ");
			int x = in.nextInt();
			if(x == 0000) break;
			boolean b = prime(x);
			System.out.println(b);
		}
		System.out.println("Enter integer to test bonus: ");
		int n = in.nextInt();
		Integer[] array = bonus(n);
		System.out.println(n + " took " + array.length + " steps to get to 1.");
		System.out.println(Arrays.toString(array));
	}

	public static boolean prime(int x){
		//Very inefficient but all I could think of
		for(int i = 2; i < x-1; i++){
			if(x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static Integer[] bonus(int x){
		List<Integer> steps = new ArrayList<Integer>();
		while(x > 1){
			if(x % 2 == 0){
				x /= 2;
			} else {
				x = x*3+1;
			}
			steps.add(x);
		}

		Integer[] i = steps.toArray(new Integer[steps.size()]);
		return i;
	}
}
