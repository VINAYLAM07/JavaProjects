package restaurentManagement;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
	protected static String RESET = "\u001B[0m";
	protected static String RED = "\u001B[31m";
	protected static String GREEN = "\u001B[32m";
	protected static String YELLOW = "\u001B[33m";

	public static void main(String[] args) {
		System.out.println(YELLOW+"\t\t\t\t\tHi Welcome to our Restaurent...\nHere is our menu for you :)"+RESET);
		int eater; 
		do {
		System.out.println("Select one from below "+YELLOW+">>>\n" + GREEN + "VEG >> 1\n" + RED + "NON-VEG >> 2" + RESET);
		Scanner sc = new Scanner(System.in);
		eater = sc.nextInt();
		try {
			if (eater == 2) {
				System.out.println(
						RED+" -NON-VEG-\n"+RESET+"|ChickenBurger(101)| Chicken-Biryani(102)| Mutton(103)|\n-DRINKS-\n|Coffee(104)|Tea(105)|Beer(106)|Coke(107)|MilkShake(108)|\n-SPECIALS-\n|French-fries(109)|Maggi(110)|Pasta(111)|");
				System.out.println("Enter the ItemCode and quantity as >>> Item:Qnty:Item:Qnty");
				String order = sc.next();
				Utility utl = new Utility(order);
				List<Map> nonVli = utl.orderDetails();
				NonVegMenu nvm = new NonVegMenu(nonVli);
				System.out.println("TOken Number: " + GREEN + nvm.generateTokenNumber() + RESET);
				System.out.println("Total Price: " + GREEN + nvm.totalPrice() + RESET);
				System.out.println("Please give us " + GREEN + nvm.PreparationTime + RESET
						+ " minuets to serve you better \n"+YELLOW+"THANK YOU!!!"+RESET);

			} else if (eater == 1) {
				System.out.println(
						GREEN+" -VEG-\n"+RESET+"|Masala Channa(101)| CheeseBurger(102)|Panner Biryani(103)|\n -DRINKS-\n|Coffee(104)|Tea(105)|Beer(106)|Coke(107)|MilkShake(108)|\n -SPECIALS-\n|French-fries(109)|Maggi(110)|Pasta(111)|");
				System.out.println("Enter the ItemCode and quantity as >>> Item:Qnty:Item:Qnty)");
				String order = sc.next();
				Utility utl = new Utility(order);
				List<Map> Vli = utl.orderDetails();
				VegMenu vm = new VegMenu(Vli);
				System.out.println("TOken Number: " + GREEN + vm.generateTokenNumber() + RESET);
				System.out.println("Total Price: " + GREEN + vm.totalPrice() + RESET);
				System.out.println("Please give us " + GREEN + vm.PreparationTime + RESET
						+ " minuets to serve you better \n"+YELLOW+"THANK YOU!!!"+RESET);
			} else {
				throw new InvalidEaterTypeException();
			}
		}catch (InvalidEaterTypeException e) {
			e.printStackTrace();
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
		}while(eater!=10);
	}
}
