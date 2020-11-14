package shopping;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Product> products;
	ArrayList<Integer> amount;
	public Inventory() {
		products = new ArrayList<Product>();
		amount = new ArrayList<Integer>();
	}
	
	public void add(Product p, Integer amt) {
		products.add(p);
		amount.add(amt);
	}
	
	public void update(Product p, Integer n) {
		amount.add(products.indexOf(p), n);
	}
	public Integer checkAmount(Product p) {
		return amount.get(products.indexOf(p));
	}
	
	public void checkItems(){
		for(int i = 0; i < products.size(); i++) {
			System.out.println("Item number: "+i+ " of product: " + products.get(i).toString());
		}
	}
	public Product getProduct(int i) {
		return products.get(i);
	}
	
	public void random() {
		products.add(new Apple(5));
		amount.add(10);
		
	}
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("The item(s) and quantities are as follows: \n");
		for (int i = 0; i < products.size(); i++) {
			b.append(String.format("%d) ", i));
			b.append(products.get(i).toString());
			b.append("has" + amount.get(i) + "items");
		}
		return b.toString();
	}
	
	public static void main(String[] args) {
		

	}

}
