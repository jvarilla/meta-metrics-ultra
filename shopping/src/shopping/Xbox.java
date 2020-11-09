package shopping;

public class Xbox extends Console {
	public int controllers;
	public String color;
	public Xbox(double p) {
		super(p);
		controllers = 1;
		color = "Black";
	}
	public Xbox(double p, String b, String g, int c, String cl) {
		super(p,b,g);
		this.controllers = c;
		this.color = cl;
	}

}
