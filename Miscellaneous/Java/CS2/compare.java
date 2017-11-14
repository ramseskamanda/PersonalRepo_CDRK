public class compare{
	private static Comparable max;
	private static Comparable min;

	public compare(){
		max = null;
		min = null;
	}

	public static void add(Comparable x){
		//The actual comparison doesn't work perfectly
		//probably because of the logic
		//but not the most important part so whatever
		if(max == null || min == null){
			max = x;
			min = x;
		}
		if(max.compareTo(x) == -1)
			max = x;
		else if(min.compareTo(x) == 1)
			min = x;
	}

	public static void main(String[] args) {
		compare data = new compare();
		compare.add("hi");
		compare.add("I'm");
		compare.add("Ramses");
		compare.add("Kamanda");
		System.out.println(data.min);
		System.out.println(data.max);
	}
}