package shopping;

public class Console extends Electronic {

	public String generation;
	
	public Console(double p) {
		super(p);
		generation = "Next Gen";
	}
	
	public Console(double p, String b, String g) {
		super(p,b);
		generation = g;
	}

}
