package shopping;

public interface ShoppingCart {
	public void add(Product p);
	public void remove(Product p);
	public void buy(Tarjet t);
	public String toString();
}
