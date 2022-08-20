package util;

import view.CommonView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private  static  Validator instance;
    private  final Scanner scanner;
    public  Validator(){
        scanner=new Scanner(System.in);
    }
    public  static  Validator getInstance(){
        return  instance=instance==null?new Validator():instance;
    }
    public  boolean checkEmpty(String string){
        return string.trim().isEmpty();
    }

    public  String emailValidate(){
        System.out.print("\tEnter email: ");
        String email=scanner.nextLine();
        boolean result= Pattern.compile(Resources.EMAIL_REGEX, Pattern.CASE_INSENSITIVE).matcher(email).find();
        if(result){
            return  email;
        }
        return  emailValidate();
    }

    public String inputString()
    {
        String input=scanner.nextLine();
        input=input.replaceAll("\\s+", "");
        input=input.trim();
        return input;
    }

    public int inputInt()
    {
        while(true)
        {
            try
            {
                String number=Validator.getInstance().inputString();
                int outnumber=Integer.parseInt(number);
                return outnumber;
            }catch(Exception e)
            {
                System.out.println("Input only integer");
            }
            System.out.println("Mời bạn nhập lại!");
        }
    }
    public  int inputIntLimit01(){

        if(scanner.hasNextInt()){
            int number=scanner.nextInt();
            if(number ==0 || number==1){
                scanner.nextLine();
                return  number;
            }
            scanner.nextLine();
            System.out.println("You must input 0,1");
            return inputIntLimit01();
        }
        scanner.nextLine();
        System.out.println("You must input 0,1");
        return inputIntLimit01();
    }


    public Double inputDouble()
    {
        while(true)
        {
            try
            {
                String number=Validator.getInstance().inputString();
                Double outnumber=Double.parseDouble(number);
                return outnumber;
            }catch(Exception e)
            {
                System.out.println("Input only Double");
            }
            System.out.println("Mời bạn nhập lại!");
        }
    }
    public Long inputLong()
    {
        while(true)
        {
            try
            {
                String number=Validator.getInstance().inputString();
                Long outnumber=Long.parseLong(number);
                return outnumber;
            }catch(Exception e)
            {
                System.out.println("Input only Long ");
            }
            System.out.println("Mời bạn nhập lại!");
        }
    }


    public String inputPassword()
    {
        while(true)
        {
            String password=Validator.getInstance().inputString();
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
    public String inputEmail()
    {
        while(true)
        {
            String email=Validator.getInstance().inputString();
            if(email.length()>15 && email.contains("@gmail.com"))
                return email;
            System.out.println("Email không đúng!");
            System.out.println("Mời bạn nhập lại!");
        }
    }


    public  String phoneValidate(){
        System.out.print("\tEnter phone number: ");
        String phone= scanner.nextLine();
        boolean result=Pattern.compile(Resources.PHONE_REGEX,Pattern.CASE_INSENSITIVE).matcher(phone).find();
        if(result){
            return  phone;
        }
        return  phoneValidate();
    }

    public  Long moneyValidate(String name){
        System.out.print("\tEnter "+name+" >= 0: ");
        if(scanner.hasNextLong()){
            long  money = scanner.nextLong();
            if(money<0){
                return  moneyValidate(name);
            }
            scanner.nextLine();
            return  money;
        }
        scanner.nextLine();
        System.out.println("You must input long");
        return  moneyValidate(name);
    }

    public  boolean Login(){
        System.out.print("\tEnter user name :");
        String userName=scanner.nextLine();
        System.out.print("\tEnter password: ");
        String pass=scanner.nextLine();
        if(userName.equals(Resources.ACCOUNT)&& pass.equals(Resources.PASS)){
            return  true;
        }
        else {
            System.out.println("\tUser name or pass is fail");
            return  false;
        }
    }


    public  LocalDate inputDate(){
        String date;
        try{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern(Resources.DATE_FORMAT);
            date=scanner.nextLine();
            return LocalDate.parse(date,formatter);
        }catch (Exception e){
            System.out.println("\tYou must input "+Resources.DATE_FORMAT);
            return  inputDate();
        }
    }

    public  LocalDate currDate(){
            LocalDate localDate = LocalDate.now();//For reference
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String date= localDate.format(formatter);
            return localDate.parse(date,formatter);
    }

}
