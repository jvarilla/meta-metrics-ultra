package shopping;

public class Customer {
	Cart c;
	String Name;
	public Customer(String n) {
		c = new Cart();
		Name = n;
	}
	
	public void add(Product p) {
		c.add(p);
	}
	public void remove(Product p) {
		c.remove(p);
	}

}
