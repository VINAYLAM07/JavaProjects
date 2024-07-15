package emailManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
	static Email user1;
	static Map<String, Email> m = new HashMap<String, Email>();

	public static void main(String[] args) throws InterruptedException {
		boolean terminate = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("Main Menu\n 1->Sign up\n 2->Forgot password\n 3->Login\n 10-> Main Menu");
				int option = sc.nextInt();
				if (option == 1) {
					System.out.println("Enter your First Name");
					String firstName = sc.next();
					System.out.println("Enter your Last Name");
					String lastName = sc.next();
					System.out.println("Enter Department Number, for sales -1, for Development -2,  for Accounting -3");
					String dept = sc.next();
					user1 = new Email(firstName, lastName, dept);
					user1.dept(dept);
					System.out.println(
							"Your Email address is Successfully Activated.\n change the Password when you login for the first time using temperary password\n which you will receive through mail\n Thank You! :)");
					user1.randomPassword();
					user1.createEmail();
					System.out.println(user1.getEmail() + "\n" + user1.getPassword());
					m.put(user1.getEmail(), user1);
				} else if (option == 2) {
					user1.changePassword();
				} else if (option == 3) {
					user1.login();
				} else if (option == 10) {
					terminate = false;
				} else {
					System.out.println("Please Enter Valid option from the List");
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please Enter valid Input");
			}
		} while (terminate == true);

	}

}
