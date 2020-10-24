package shopping;


import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void showMenu(CMenu[] cm) {
		for(CMenu m : cm) {
			System.out.printf("%d) %s%n", m.ordinal(), m.toString());
		}
	}
	
	public static void addCart(Scanner s) {
		Tarjet.i.checkItems();
		s.nextInt();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Tarjet t = new Tarjet();
		int i;
		Scanner s = new Scanner(System.in);
		//ArrayList q = Tarjet.i.products;
		CMenu[] menu = CMenu.values();
		
		do {
			System.out.println("Make a Selection");
			showMenu(menu);
			i = s.nextInt();
			if(i == 0) {
				addCart(s);
			}
			
		}while(i != 4);
		
	}

}
