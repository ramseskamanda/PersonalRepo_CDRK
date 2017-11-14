public class bank{

	public static double balance;
	private static final double TRANSACTION_FEE = 100;
	private static int num_free = 10;
	private static long account_number;
	private static long counter = 1;
	private static String transaction_history = "";

	public bank(double initialBalance){
		account_number = counter;
		balance = initialBalance;
		counter++;
		String opening = "Account number: " + String.valueOf(account_number) + " was opened with initial balance " + String.valueOf(initialBalance) + "\n";
		String.join(transaction_history, opening);
	}

	public void deposit(double amount){
		double newBalance = balance + amount;
		balance = newBalance;
		num_free--;
		String deposit = "Bank Account: " + String.valueOf(account_number) + " deposit " + String.valueOf(amount) + " euros.\n";
		String.join(transaction_history, deposit);
	}

	public void withdraw(double amount){
		double newBalance = balance - amount;
		balance = newBalance;
		num_free--;
		String withdrawal = "Bank Account: " + String.valueOf(account_number) + " withdrawal " + String.valueOf(amount) + " euros.\n";
		String.join(transaction_history, withdrawal);
	}

	public double getBalance(){
		return balance;
	}

	public void deductMonthlyCharge(){
		balance = balance - (num_free*TRANSACTION_FEE);
		num_free = 10;
	}


	public static void main(String[] args) {
		bank account = new bank(1000);
		for(int i = 0; i < 11; i++){
			account.withdraw(20);
			account.deposit(10);
		}
		System.out.println(account.getBalance());
		account.deductMonthlyCharge();
		System.out.println(account.getBalance());
	}
}