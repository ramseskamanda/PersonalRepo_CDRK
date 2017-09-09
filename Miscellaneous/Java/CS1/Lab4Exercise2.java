import java.util.Scanner;

public class Lab4Exercise2{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter unspecified number of integers, to end use any letter.");
		String s = in.nextLine();
		String[] numbersArray = s.split(" ");
		int[] intsArray = new int[numbersArray.length-1];
		for(int i = 0; i < numbersArray.length-1; i++){
			intsArray[i] = Integer.parseInt(numbersArray[i]);
			System.out.print(intsArray[i] + ", ");
		}
		int max = find_max(intsArray);
		int min = find_min(intsArray);
		System.out.println("Min: " + min + " Max: " + max);
	}

	public static int find_max(int[] array){
		int max = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i]>max) max = array[i];
		}
		return max;
	}

	public static int find_min(int[] array){
		int min = array[0];
		for(int i = 0; i < array.length; i++){
			if(array[i]<min) min = array[i];
		}
		return min;
	}
}
