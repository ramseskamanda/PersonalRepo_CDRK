import java.lang.Integer;
import java.util.ArrayList;
import java.util.Random;

public class sorting{
	public static Random rand = new Random();

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr){
		ArrayList<Integer> result = new ArrayList();
		if(arr.size() < 2)
			return arr;
		int mid = (int) arr.size() / 2;
		Object[] cut = cutArray(arr, mid);
		ArrayList<Integer> y = mergeSort((ArrayList<Integer>) cut[0]);
		ArrayList<Integer> z = mergeSort((ArrayList<Integer>) cut[1]);
		int i = 0;
		int j = 0;
		while(i < y.size() && j < z.size()){
			if(y.get(i) > z.get(j)){
				result.add(z.get(j));
				j += 1;
			}
			else{
				result.add(y.get(i));
				i += 1;
			}
		}
		ArrayList<Integer> addtoresult = (ArrayList<Integer>) cutArray(y, i)[1];
		ArrayList<Integer> alsoaddtoresult = (ArrayList<Integer>) cutArray(z, j)[1];
		result.addAll(addtoresult);
		result.addAll(alsoaddtoresult);
		return result;
	}

	public static ArrayList<Integer> mergeSortBubble(ArrayList<Integer> arr){
		ArrayList<Integer> result = new ArrayList();
		if(arr.size() < 20)
			result = bubbleSort(arr);
		else{
			int mid = (int) arr.size() / 2;
			Object[] cut = cutArray(arr, mid);
			ArrayList<Integer> y = mergeSort((ArrayList<Integer>) cut[0]);
			ArrayList<Integer> z = mergeSort((ArrayList<Integer>) cut[1]);
			int i = 0;
			int j = 0;
			while(i < y.size() && j < z.size()){
				if(y.get(i) > z.get(j)){
					result.add(z.get(j));
					j += 1;
				}
				else{
					result.add(y.get(i));
					i += 1;
				}
			}
			ArrayList<Integer> addtoresult = (ArrayList<Integer>) cutArray(y, i)[1];
			ArrayList<Integer> alsoaddtoresult = (ArrayList<Integer>) cutArray(z, j)[1];
			result.addAll(addtoresult);
			result.addAll(alsoaddtoresult);
		}
		return result;
	}

	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr){
		int n = arr.size();  
		int temp = 0;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(arr.get(j-1) > arr.get(j)){ 
					temp = arr.get(j-1);
					arr.set(j-1, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
		return arr;
	}

	public static Object[] cutArray(ArrayList<Integer> arr, int mid){
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		for(int i = 0; i < arr.size(); i++){
			if(i < mid) first.add(arr.get(i));
			else second.add(arr.get(i));
		}
		return new Object[]{first, second};
	}

	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList();
		for(int i = 0; i < 10; i++)
			test.add(rand.nextInt(10));
		System.out.println(mergeSortBubble(test));
	}
}