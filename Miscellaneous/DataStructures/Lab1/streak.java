import java.util.Arrays;

public class streak{

	public static int[] longestStreak(int[] array){
		int biggest = 0;
		int start = 0;
		int end = 0;
		for(int i = 1; i < array.length; i++){
			if(array[i - 1] > array[i]){
				if(biggest < (i - 1) - start){
					end = i - 1;
					biggest = end - start;
				}
				if(array.length - i < biggest) break;
				else start = i;
			}
		}
		start = end - biggest;
		int[] arrayToReturn = new int[biggest + 1];
		for(int i = 0; i <= biggest; i++)
			arrayToReturn[i] = array[start + i];
		return arrayToReturn;
	}

	public static void main(String[] args) {
		int[] t1 = new int[]{1, 3, 4, 5, 6, -1, 2, 1, 2, 1, 2};
		int[] t2 = new int[]{1, 2, 3, 4, 5, 6, -1, 2, 1, 2, 1, 2};
		int[] t3 = new int[]{-1, 2, 5,1, 2, 1, 2};
		int[] solution1 = longestStreak(t1);
		int[] solution2 = longestStreak(t2);
		int[] solution3 = longestStreak(t3);
		System.out.print(Arrays.toString(solution1));
		System.out.print(Arrays.toString(solution2));
		System.out.print(Arrays.toString(solution3));
	}
}