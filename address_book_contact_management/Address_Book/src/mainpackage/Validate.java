package mainpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Validate
{
    public boolean validate_Name(String Name)
    {

        if (Name.equals(""))
        {
            System.out.println("Field cannot be left blank");
            return false;
        }
        //check if name starts with an upper Case
        if(!Character.isUpperCase(Name.charAt(0)))
        {
            System.err.println("Name must start with an Upper Case");
            return false;
        }



        char[] characters = Name.toCharArray();

        for(char c : characters)
        {
            int ascii = c;

            // check if Name starts with a special character
            if (Name.indexOf(c) == 0)
            {
                if ((ascii <= 47) || (ascii >= 58 &&  ascii <= 64) || (ascii >= 91 && ascii <= 96) || (ascii >= 123))
                {
                    System.err.println("Invalid input!\nName cannot start with a special characters");
                    return false;
                }
            }


            // check if Name starts a number letter
            if (Name.indexOf(c) == 0)
            {
                if (Character.isDigit(c))
                {
                    System.err.println("Invalid input! Name cannot start with a number");
                    return false;
                }
            }


            // checking if there is an uppercase mid string
            if (Name.indexOf(c) != 0)
            {


                //System.out.println(prevChar + "\n" + asc + "\n" + Name.charAt(Name.indexOf(c)));
                if (Character.isUpperCase(c) == true)
                {
                    //asc means ascii
                    int asc = Name.charAt(Name.indexOf(c)-1);
                    //char prevChar = (char) asc;
                    //System.out.println(asc == 45);
                    //System.out.println(prevChar);

                    if ((asc == 32) || (asc == 45) || (asc == 46) || (asc == 39))
                    {

                    }
                    else
                    {
                        System.err.println("Invalid input!\nName cannot contain an uppercase except for\nthe 1st letter or if that uppercase\nis preceded by authorised special characters");
                        return false;
                    }
                }

            }


            if (Character.isDigit(c)) {
                System.err.println("Invalid input! Name cannot contain a Number");
                return false;
            }

            if ((ascii >= 33 && ascii <= 38) || (ascii >= 40 &&  ascii <= 44) || ascii == 47 || (ascii >= 58 && ascii <= 64) || (ascii >= 91 && ascii <= 96) || ascii >= 123)
            {
                System.err.println("Invalid input!\nName cannot contain any other\nspecial characters apart period (.),\napostrophe ('), hyphen/dash (-), and spaces");
                return false;
            }
        }
        return true;
    }


    public boolean validate_Email(String Email)
    {
        int at_Index = Email.indexOf('@');

        if (at_Index == 0)
        {
            System.err.println("Invalid Email! Email cannot start with @");
            return false;
        }

        String domain =  new String();
        domain = Email.substring(at_Index+1, Email.length());

        try {
            File emailDomain = new File(System.getProperty("user.dir")+"/Address_Book/src/email_domain.txt");
            Scanner myReader = new Scanner(emailDomain);
            while (myReader.hasNextLine()) {
                String validDomain = myReader.nextLine();

                if (domain.equals(validDomain))
                {
                    return true;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("An error occurred read operation on email_domain.txt failed");
            e.printStackTrace();
        }
        System.err.println("Invalid Email domain");
        return false;
    }


    public boolean validate_Zipcode(String zipcode)
    {
        if (zipcode.length() != 10)
        {
            System.err.println("Invalid zipcode length!\nA zipcode must start with 5-digits\nfollowed by a hyphen(-) then end with 4 digits");
            return false;
        }

        if (!(zipcode.substring(5,6).equals("-")))
        {
            System.err.println("Invalid zipcode!\nA zipcode must start with 5-digits\nfollowed by a hyphen(-) then end with 4 digits");
            return false;
        }

        String first_part = new String();
        char[] character = new char[5];

        first_part = zipcode.substring(0,5);
        character = first_part.toCharArray();

        for (char c : character)
        {
            if (!Character.isDigit(c))
            {
                System.err.println("Invalid character detected!\nA zipcode must start with 5-digits followed\nby a hyphen(-) then end with 4 digits");
                return false;
            }
        }

        String second_part = new String();
        second_part = zipcode.substring(6,10);
        character = second_part.toCharArray();

        for (char c : character)
        {
            if (!Character.isDigit(c))
            {
                System.err.println("Invalid character detected!\nA zipcode must start with 5-digits followed\nby a hyphen(-) then end with 4 digits");
                return false;
            }
        }

        return true;
    }

}
