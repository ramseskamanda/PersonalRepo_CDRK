public class Manager extends Employee{
	public static String department;

	public Manager(String n, int s, String d){
		super(n, s);
		department = d;
	}

	@Override
	public String toString(){
		return this.name + " " + this.department + " " + String.valueOf(this.salary);
	}
}