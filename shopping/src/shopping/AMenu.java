package shopping;

public enum AMenu {
	Add("Create new Product"), Remove("Remove products"), Update("Update total"), Exit("Return to CMenu");
	
private String description;
	
	AMenu(String name){
		description = name;
	}

	public String toString() {
		return description;
	}
}
