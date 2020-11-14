package shopping;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void showCMenu(CMenu[] cm) {
		for(CMenu m : cm) {
			System.out.printf("%d) %s%n", m.ordinal(), m.toString());
		}
	}
	
	public static void showAMenu(AMenu[] cm) {
		for(AMenu m : cm) {
			System.out.printf("%d) %s%n", m.ordinal(), m.toString());
		}
	}
	
	public static void addCart(Scanner s, Tarjet t, Cart c) {
		System.out.println("Make a selection to add to cart");
		t.i.checkItems();
		Product p = t.i.getProduct(s.nextInt());
		c.add(p);
		
	}
	
	public static void remove(Scanner s, Cart c) {
		System.out.println("Select product to remove");
		for(int i = 0; i < c.c.size(); i++) {
			System.out.println("Item number: "+i+ " of product: " + c.c.get(i).toString());
		}
		c.remove(c.c.get(s.nextInt()));
	}
	
	public static boolean buy(Scanner s, Cart c, Tarjet t) {
		System.out.print("Buy everything in your cart? Y or N");
		String choice = s.next();
		if(choice.equals("Y")) {
			c.buy(t);
			return true;
		}else {
			System.out.println("Returning to selection screen");
			return false;
		}
		
	}
	
	public static void show(Cart c) throws InterruptedException {
		double total = 0;
		for(int i = 0; i < c.c.size(); i++) {
			total += c.c.get(i).getPrice();
			System.out.println("Item number: "+i+ " of product: " + c.c.get(i).toString());
		}
		System.out.println(String.format("Total: $%.2f", total));
		TimeUnit.SECONDS.sleep(5);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Tarjet t = new Tarjet();
		int i;
		Scanner s = new Scanner(System.in);
		Cart c = new Cart();
		CMenu[] menu = CMenu.values();
		
		while(true) {
			System.out.println("Make a Selection");
			showCMenu(menu);
			i = s.nextInt();
			if(i == 0) {
				addCart(s, t, c);
			}else if(i == 1) {
				//remove
				remove(s,c);
			}else if(i == 2) {
				//buy
				boolean purchase = buy(s,c,t);
				if(purchase == true) {
					break;
				}
				
			}else if(i==3) {
				//show
				show(c);
			}else if(i==4) {
				launchA(s,t);
			}else {
				break;
			}
			
		}
		
	}

	private static void launchA(Scanner s, Tarjet t) {
		AMenu[] am = AMenu.values();
		showAMenu(am);
		int i;
		while(true) {
			i = s.nextInt();
			if(i==0) {
				//new
				newProduct(s,t);
			}else if(i == 1) {
				//remove
				remove(s,t);
			}else if(i == 2) {
				//update
				update(s,t);
			}
			else break;
		}
		
	}
	
	public static void newProduct(Scanner s, Tarjet t) {
		System.out.println("What product will you create?");
		System.out.println("0: Xbox");
		System.out.println("1: Wood");
		System.out.println("2: Apple");
		int i = s.nextInt();
		if(i == 0) {
			System.out.println("Enter price");
			double p = s.nextDouble();
			Product x = new Xbox(p);
			System.out.println("How many will be abvailable");
			int amt = s.nextInt();
			t.i.add(x, amt);
		}
		else if(i==1) {
			System.out.println("Enter price");
			double p = s.nextDouble();
			Product w = new Wood(p);
			System.out.println("How many will be abvailable");
			int amt = s.nextInt();
			t.i.add(w, amt);
		}else if(i==2) {
			System.out.println("Enter price");
			double p = s.nextDouble();
			Product a = new Apple(p);
			System.out.println("How many will be abvailable");
			int amt = s.nextInt();
			t.i.add(a, amt);
		}
	}
	
	public static void remove(Scanner s, Tarjet t) {
		System.out.print("Which product will you remove?:");
		for(int i = 0; i < t.i.products.size(); i++) {
			System.out.println("Item number: "+i+ " of product: " + t.i.products.get(i).toString());
		}
		int index = s.nextInt();
		t.i.amount.remove(index);
		t.i.products.remove(index);
	}
	
	public static void update(Scanner s, Tarjet t) {
		System.out.print("Which product will you update?:");
		for(int i = 0; i < t.i.products.size(); i++) {
			System.out.println("Item number: "+i+ " of product: " + t.i.products.get(i).toString());
		}
		int index = s.nextInt();
		System.out.println("By how much?");
		int amt = s.nextInt();
		t.i.update(t.i.getProduct(index), amt);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
