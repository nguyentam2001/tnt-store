package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private static Scanner sc=new Scanner(System.in);
    public static String inputString()
    {
        String input=sc.nextLine();
        input=input.replaceAll("\\s+", "");
        input=input.trim();
        return input;
    }
    public static int inputInt()
    {
        while(true)
        {
            try
            {
                String number=Validator.inputString();
                int outnumber=Integer.parseInt(number);
                return outnumber;
            }catch(Exception e)
            {
                System.out.println("Input only integer");
            }
            System.out.println("Mời bạn nhập lại!");
        }
    }

    public static Double inputDouble()
    {
        while(true)
        {
            try
            {
                String number=Validator.inputString();
                Double outnumber=Double.parseDouble(number);
                return outnumber;
            }catch(Exception e)
            {
                System.out.println("Input only Double");
            }
            System.out.println("Mời bạn nhập lại!");
        }
    }
    public static Long inputLong()
    {
        while(true)
        {
            try
            {
                String number=Validator.inputString();
                Long outnumber=Long.parseLong(number);
                return outnumber;
            }catch(Exception e)
            {
                System.out.println("Input only Long ");
            }
            System.out.println("Mời bạn nhập lại!");
        }
    }
    public static String inputEmail()
    {
        while(true)
        {
            String email=Validator.inputString();
            if(email.length()>15 && email.contains("@gmail.com"))
                return email;
            System.out.println("Email không đúng!");
            System.out.println("Mời bạn nhập lại!");
        }
    }
    public static String inputPassword()
    {
        while(true)
        {
            String password=Validator.inputString();
            if(password.length()>5 && password.length()<13)
            {
                boolean kt=false;
                for(int i=0;i<password.length();i++)
                {
                    char ch=password.charAt(i);
                    if(Character.isUpperCase(ch))
                    {
                        kt=true;
                        break;
                    }
                }

                if(kt==true)
                    return password;
            }
            System.out.println("Password có độ dài 6-12 ký tự và ít nhất 1 chữ viết hoa!");
            System.out.println("Mời bạn nhập lại!");
        }
    }

    public static String inputFullname()
    {
        while(true)
        {
            Pattern pattern=Pattern.compile("^[a-zA-Z]*$");
            String fullname=Validator.inputString();
            if( pattern.matcher(fullname).matches())
                return fullname;
            System.out.println("FullName chỉ chứa chữ");
        }
    }

}
