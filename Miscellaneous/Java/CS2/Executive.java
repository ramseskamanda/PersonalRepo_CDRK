public class Executive extends Manager{
	public Executive(String n, int s, String d){
		super(n, s, d);
	}

	public static void main(String[] args) {
		Employee e = new Employee("George", 20000);
		Manager m = new Manager("Doug", 50000, "IT");
		Executive ex = new Executive("Michelle", 100000, "IT");
		System.out.println(e.toString());
		System.out.println(m.toString());
		System.out.println(ex.toString());
	}
}