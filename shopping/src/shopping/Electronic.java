package shopping;

public class Electronic extends Product {
	String brand;
	public Electronic(double p) {
		super(p);
		brand = "Samsung";
		// TODO Auto-generated constructor stub
	}
	
	public Electronic(double p, String b) {
		super(p);
		brand  = b;
	}

}
