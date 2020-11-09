package shopping;

public class Wood extends Product {
	public String type;
	public String color;
	public double areaFt;
	
	public Wood(double p) {
		super(p);
		type = "Oak";
		color = "Light";
		areaFt = 24;
			
	}

	public Wood(double p, String t, String c, double a ) {
		super(p);
		type = t;
		color = c;
		areaFt = a;
		
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(color.toUpperCase()+ " " + type.toUpperCase()+ " has an area of ");
		b.append(String.format("%.2f sqft", areaFt));
		b.append(String.format("and costs $%.2f", this.getPrice()));
		return b.toString();
	}
}
