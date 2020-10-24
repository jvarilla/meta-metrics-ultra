package shopping;

import java.util.ArrayList;

public class Cart {
	public ArrayList<Product> c;
	public int total;
	public Cart() {
		c = new ArrayList<Product>();
	}
	public void add(Product p) {
		c.add(p);
	}
}
