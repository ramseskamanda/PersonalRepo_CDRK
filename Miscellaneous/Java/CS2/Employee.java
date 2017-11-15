public class Employee{
	public String name;
	public int salary;

	public Employee(String n, int s){
		this.name = n;
		this.salary = s;
	}

	@Override
	public String toString(){
		return this.name + " " + String.valueOf(this.salary);
	}
}