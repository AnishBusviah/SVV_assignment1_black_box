package mainpackage;

import java.io.*;
import java.util.Scanner;

public class Add extends Main{
	public static void add_contact() throws IOException, FileNotFoundException{
		File file1 = new File(System.getProperty("user.dir")+"/Address_Book/src/contacts.txt");// we get the file
		BufferedReader reader1 = new BufferedReader(new FileReader(file1)); // we get reader for the file
		OutputStreamWriter writer1 = new OutputStreamWriter(
                new FileOutputStream(System.getProperty("user.dir")+"/Address_Book/src/contacts.txt", true), "UTF-8");
		BufferedWriter writer = new BufferedWriter(writer1);//this is a way to get a writer for th specific file
		Scanner input= new Scanner(System.in);
		boolean duplicate, valid;
		String currentLine1;
		String f1 = "";//I initialize the variablesto avoid errors
		String f2 = "";
		String f5 = "";
		String f6 = "";
		String f8 = "";
		int f3 = -1;
		int f4 = -1;
		int f7 = -1;
		//int f9 = -1;
		String f9 = new String();
		String str;

		boolean validation = false;

		Validate check = new Validate();

		while (!validation)
		{
			System.out.println("Give First Name: ");
			f1 = input.nextLine();
			validation = check.validate_Name(f1);
		}

		validation = false;

		while (!validation)
		{
			System.out.println("Give Surname: ");
			f2 = input.nextLine();
			validation = check.validate_Name(f2);
		}


		do
		{//this is a do-while loop in which I check for valid input (must me integer) and i loop through the txt file again to check if input is duplicate
			duplicate = false;
			valid = true;
			System.out.println("Give Telephone: ");
			//f3 = input.nextInt();
			try {

			    f3 = Integer.parseInt(input.nextLine());

			} catch (NumberFormatException e) {
				valid = false;
				System.err.println("Telephone must be number.");
			    //e.printStackTrace();
			}

			if (Integer.toString(f3).length() != 7)
			{
				System.err.println("Invalid Input! Telephone number must be 7-digits long");
				valid = false;
			}

			while((currentLine1 = reader1.readLine()) != null) {//check for duplicate
				String[] words1=currentLine1.split(",");
				if(words1[2].equals(String.valueOf(f3))) {
						duplicate=true;
						System.out.println("Invalid input! Phone must be unique among the contacts.");
				}
			}
			reader1 = new BufferedReader(new FileReader(file1));
		} while (duplicate == true || valid == false);



		do {
			duplicate = false;
			valid = true;
			System.out.println("Give Mobile phone: ");
			//f4 = input.nextInt();
			try {
			    f4 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
			    //e.printStackTrace();
				System.out.println("Invalid Input! Mobile phone must be number.");
				valid = false;
			}



			if (Integer.toString(f4).substring(0,1).equals("5"))
			{
				valid = true;
			}
			else
			{
				System.err.println("Invalid Input! Mobile number must start with 5");
				valid = false;
			}

			if (Integer.toString(f4).length() != 8)
			{
				System.err.println("Invalid Input! Mobile number must be 8-digits long");
				valid = false;
			}

			while((currentLine1 = reader1.readLine()) != null) {//check for duplicate
				String[] words1=currentLine1.split(",");
				if(words1[3].equals(String.valueOf(f4))) {
						duplicate=true;
						System.out.println("Invalid Input! Mobile Phone must be unique among the contacts.");
				}
			}
			reader1 = new BufferedReader(new FileReader(file1));
		}while (duplicate == true || valid == false);
		do {
			valid = false;
			duplicate = false;
			System.out.println("Give E-mail: ");
			f5 = input.nextLine();
			while((currentLine1 = reader1.readLine()) != null) {//check for duplicate
				String[] words1=currentLine1.split(",");
				if(words1[4].equals(f5)) {
						duplicate=true;
						System.out.println("E-mail must be unique among the contacts.");
				}
			}
			reader1 = new BufferedReader(new FileReader(file1));

			valid = check.validate_Email(f5);


		}while (duplicate == true || valid == false);
		System.out.println("Give Street Name: ");
		f6 = input.nextLine();
		System.out.println("Give street number: ");
		//f7 = input.nextInt();
		do {
			valid = true;
			try {
			    f7 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
			    //e.printStackTrace();
				System.err.println("Street number must be a number.");
				valid = false;
			}
		}while(valid == false);
		System.out.println("Give town Name: ");
		f8 = input.nextLine();
		//System.out.println("Give Zip code: ");
		//f9 = input.nextInt();

		valid = false;
		do {
			System.out.println("Give Zip code: ");
			f9 = input.nextLine();

			valid = check.validate_Zipcode(f9);
			/*try {
			    f9 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
			    //e.printStackTrace();
				System.err.println("Zip code must be a number.");
				valid = false;
			}*/
		}while(valid == false);
		if(f1 == "" || f2 == "" || f5 == "" || f6 == "" || f8 == "" || f3 == -1 || f4 == -1 || f7 == -1 || f9 == "") {//i check that all variables have a valid attribute assigned
			System.out.println("You gave false inputs, adding new contact wasn't successful: ");
		}
		else {//if everything is correct i build a string
			str = f1 + "," + f2 + "," + String.valueOf(f3) + "," + String.valueOf(f4) + "," + f5 + "," + f6 + "," + String.valueOf(f7) + "," + f8 + "," + String.valueOf(f9);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));//with these code I add a line at the bottom of the file
			out.println(str);
			out.close();
			System.out.println("Entry was successful!");
		}
		//input.close();
		//writer1.close();
		writer.close(); 
		reader1.close(); 
	}

}
