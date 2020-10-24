package shopping;

public enum CMenu {
	Add("Add to Cart"), Remove("Remove from Cart"), Buy("Buy items in cart"), Show("Show items and total"),Exit("exit");
	
	private String description;
	
	CMenu(String name){
		description = name;
	}

	public String toString() {
		return description;
	}
}
