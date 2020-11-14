package shopping;

public final class Tarjet implements Store{
	public Inventory i = new Inventory();
	public double profit;
	private final String password;
	public Tarjet() {
		profit = 0;
		i.random();
		password = "password";
	}
	
	public Tarjet(String p) {
		profit = 0;
		password = p;
	}

	public String getPassword() {
		return password;
	}
	
	public Customer newCustomer(String n) {
		return new Customer(n);
		
	}
	public void bought(Product p) {
		this.profit += p.getPrice();
	}
}
