public class TimeDepositAccount extends bank{
	public static int months_to_maturity;
	public static double interest_rate;
	public static final double PENALTY = 100;

	public TimeDepositAccount(double initialBalance, double interestRate, int months){
		super(initialBalance);
		interest_rate = interestRate;
		months_to_maturity = months;
	}

	public static void addInterest(){
		balance *= interest_rate;
		months_to_maturity--;
	}


	public void withdrawal(double amount){
		double transact = 0;
		if(months_to_maturity > 0)
			transact = amount += PENALTY;
		double newBalance = balance - transact;
		this.balance = newBalance;
	}


	public static void main(String[] args) {
		TimeDepositAccount a = new TimeDepositAccount(1000, 0.2, 2);
		a.addInterest();
		a.addInterest();
		a.withdrawal(50);
		System.out.println(a.getBalance());
	}
}