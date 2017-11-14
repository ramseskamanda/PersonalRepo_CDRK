public class DataSetBank{
	private Measurer measurer;
	private Filter filter;
	private Object[] allAccounts = new Object[100];
	private int num_accounts;
	private double total_bank_money;

	public DataSetBank(Measurer m, Filter f){
		measurer = m;
		filter = f;
		num_accounts = 0;
		total_bank_money = 0;
	}

	public void add(Object account){
		if(filter.accept(account)){
			num_accounts += 1;
			allAccounts[num_accounts] = account;
			total_bank_money += measurer.getBalance(account);
		}
	}

	public int getNumAccounts(){
		return num_accounts;
	}

	public double getBankMoney(){
		return total_bank_money;
	}

	public static void main(String[] args) {
		class AccountMeasurer implements Measurer{
			public double getBalance(Object account){
				bank a = (bank)account;
				return a.balance;
			}
		}
		class AccountFilter implements Filter{
			public boolean accept(Object account){
				bank a = (bank)account;
				if(a.balance > 1000)
					return true;
				return false;
			}
		}
		Measurer m = new AccountMeasurer();
		Filter f = new AccountFilter();

		DataSetBank data = new DataSetBank(m, f);

		data.add(new bank(50000));
		data.add(new bank(100));
		data.add(new bank(0));
		data.add(new bank(2000));
		data.add(new bank(1000000));

		System.out.println("Number of accounts is " + data.getNumAccounts());
		System.out.println("Total bank money is " + data.getBankMoney());
	}
}

interface Measurer{
	double getBalance(Object account);
}

interface Filter{
	boolean accept(Object account);
}