package shopping;

public class Product implements Item{
	private double price;

	public Product(double p) {
		setPrice(p);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
