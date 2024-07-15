package emailManager;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Email {

	protected String firstName;
	protected String lastName;
	protected String Password;
	protected String department;
	protected String email;
	protected String Company = "cognizant";
	protected int mailBoxCapacity;

	UserInterface ui;
	Scanner sc;

	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}

	public void setMailBoxCapacity(int mailBoxCapacity) {
		this.mailBoxCapacity = mailBoxCapacity;
	}

	public Email(String firstName, String lastName, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public void dept(String deptno) {

		if (deptno.equals("1")) {
			department = "sales";
		} else if (deptno.equals("2")) {
			department = "development";
		} else if (deptno.equals("3")) {
			department = "accounting";
		}
	}

	public void randomPassword() {
		Random r = new Random();
		StringBuilder pswd = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int n = r.nextInt(127);
			if (n >= 48 && n <= 57) {
				pswd.append(String.valueOf(n));
			} else if (n >= 97 && n <= 122 || n >= 65 && n <= 90) {
				pswd.append((char) n);
			}
		}
		Password = pswd.toString();

	}

	public void createEmail() {
		email = firstName + "." + lastName + "@" + department + "." + Company + ".com";
		if (!email.matches("\\w+[.]\\w+[@]\\w+[.]\\w+[.]\\w+"))
			System.out.println("There was a problem while generating Email");
		setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void changePassword() {
		sc = new Scanner(System.in);
		ui = new UserInterface();
		for (Map.Entry<String, Email> me : ui.m.entrySet()) {
			System.out.println("Enter Registered Email Address");
			String confirmEmail = sc.nextLine();
			if (me.getValue().getEmail().equalsIgnoreCase(confirmEmail)) {
				System.out.println("Enter your old password");
				String enteredOldPwd = sc.nextLine();
				if (me.getValue().getPassword().equals(enteredOldPwd)) {
					System.out.println(
							"Enter your new password [Note: Minium one UpperCase, one LowerCase, one SpecialCharacter"
									+ "of length minium 8 is required for new Password. ");
					String newPwd = sc.nextLine();
					if (newPwd.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,}")) {
						System.out.println("Enter your new password Again");
						if (newPwd.equals(sc.nextLine())) {
							me.getValue().setPassword(newPwd);
							System.out.println("Your Password Updated Successfully");
							System.out.println("\t\t\t\t\t\t\t Logged in as " + me.getKey());
						} else {
							System.out.println("Password is not matched!");
							break;
						}
					} else {
						System.out.println("Password doesn't match with requirements");
						break;
					}

				} else {
					System.out.println("Your Old Password is wrong");
					break;
				}
			}else {
				System.out.println("Email doesn't registered!");
			}
		}
	}

	public void login() {
		System.out.println("Enter your Email address");
		Scanner sc = new Scanner(System.in);
		String email = sc.nextLine();
		ui = new UserInterface();

		for (String key : ui.m.keySet()) {
			if (key.equalsIgnoreCase(email)) {
				System.out.println("Enter your Password");
				if (ui.m.get(key).getPassword().equalsIgnoreCase(sc.next())) {
					System.out.println("Login Successfull !!!");
					System.out.println("\t\t\t\t\t\t\t Logged in as " + ui.m.get(key).getEmail());
				} else {
					System.out.println("Incorrect password");
					break;
				}
			} else {
				System.out.println("Incorrect Email Entered");
				break;
			}
		}

	}

}
