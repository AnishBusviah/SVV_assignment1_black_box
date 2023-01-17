package mainpackage;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		int exit = 0;
		String answer = new String();
		//we will loop until user wants to exit the application
		int choice;
		do {
			System.out.println("--------Welcome to Address Book---------");
			System.out.println("Enter '1' to Add contact");
			System.out.println("Enter '2' to Search contact");
			System.out.println("Enter '3' to Print contact");
			System.out.println("Enter '4' to Edit contact");
			System.out.println("Enter '5' to Delete contact");
			System.out.println("Enter '0' to Exit");
			System.out.println("Do you want to print contacts, add contact, search for contact, edit contact or delete contact?");
			System.out.println("Answer with '1', '2', '3', '4', '5' or '0' to exit application.");
			choice = 0;
			try {//we handle the input of the user
				answer = input.nextLine();
				choice = Integer.parseInt(answer);

				if (choice < 0 || choice >5)
				{
					System.err.println("Invalid Choice! Input out of range");
				}
			} catch (Exception e) {
				//e.printStackTrace();
				System.err.println("Invalid Choice! Input must be an integer");
				choice = -1;

			}
			if (choice == 1)//according to user's input we go to each class

				Add.add_contact();
			else if (choice == 2)
				Search.choose_field();
			else if (choice == 3)
				Print.show_contacts();
			else if (choice == 4)
				Change.choose_field();
			else if (choice == 5)
				Delete.choose_field();


		} while (choice != 0);
		System.out.println("Application terminating...");
	}
}
