class DataSet{
	private double sum_heights;
	private int count;
	private Object tallest;
	private Measurer measurer;

	public DataSet(Measurer m){
		sum_heights = 0;
		count = 0;
		tallest = null;
		measurer = m;
	}

	public void add(Object p){
		sum_heights += measurer.getHeight(p);
		if(count == 0 || measurer.getHeight(tallest) < measurer.getHeight(p))
			tallest = p;
		count++;
	}

	public double getAverageHeight(){
		if(count == 0)
			return 0;
		return sum_heights / count;
	}

	public String nameTallest(){
		return measurer.getNameTallest(tallest);
	}

	public static void main(String[] args) {
		class PersonMeasurer implements Measurer{
			public double getHeight(Object p){
				Person pers = (Person)p;
				return pers.height;
			}
			public String getNameTallest(Object p){
				Person pers = (Person)p;
				return pers.name;
			}
		}
		Measurer m = new PersonMeasurer();

		DataSet data = new DataSet(m);

		data.add(new Person("Charlotte", 183.3));
		data.add(new Person("Ramses", 190));
		data.add(new Person("Ben", 175.8));
		data.add(new Person("George", 201.9));
		data.add(new Person("Anna", 145.3));

		System.out.println("Average Height = " + data.getAverageHeight());
		System.out.println("Tallest person is " + data.nameTallest());
	}
}

interface Measurer{
	double getHeight(Object p);
	String getNameTallest(Object p);
}
