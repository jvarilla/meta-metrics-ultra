package shopping;

import java.util.ArrayList;

public class Cart implements ShoppingCart{
	public ArrayList<Product> c;
	public double total;
	public Cart() {
		c = new ArrayList<Product>();
	}
	public void add(Product p) {
		c.add(p);
		total += p.getPrice();
	}
	
	public void remove(Product p) {
		c.remove(p);
		total -= p.getPrice();
	}
	public void buy(Tarjet t) {
		for(Product p: c) {
			Integer i = t.i.checkAmount(p);
			if(i> 1) {
				t.i.update(p, i-1);
			}
			t.bought(p);
		}
	}
	public String toString() {
		StringBuilder b = new StringBuilder();
		int counter = 1;
		for(int i = 0; i < c.size(); i++) {
			b.append(counter + ") "+ c.get(i).toString());
			b.append("\n");
		}
		b.append("The total is: ");
		b.append(String.format("$%.2f", total));
		return b.toString();
	}
}
