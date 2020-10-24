package shopping;

public class Apple extends Food {
	private final String type;
	
	public Apple(double p, double c, double g) {
		super(p, c, g);
		type = "Honey Crisp";
	}
	public Apple(double p, double c, double g, String s) {
		super(p,c,g);
		type = s;
	}
	public String getType() {
		return type;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(String.format("%s costs $%.2f", type,this.getPrice()));
		return b.toString();
	}
}
