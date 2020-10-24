package shopping;

public class Food extends Product {
	private final double calories;
	private final double grams;
	public Food(double p) {
		super(p);
		calories = 100;
		grams = 5;
		
	}
	public Food(double p, double c, double g) {
		super(p);
		calories = c;
		grams =g;
	}
	public double getCalories() {
		return calories;
	}
	public double getGrams() {
		return grams;
	}

}
