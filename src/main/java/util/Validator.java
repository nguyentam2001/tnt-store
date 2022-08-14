package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private  static  Validator instance;
    private  Scanner scanner;
    public  Validator(){
        scanner=new Scanner(System.in);
    }
    public  static  Validator getInstance(){
        return  instance=instance==null?new Validator():instance;
    }
    public  boolean checkEmpty(String string){
        if(string.trim().isEmpty()){
            return  true;
        }
        return  false;
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
        long money = scanner.nextLong();
        if(money<0){
            return  moneyValidate(name);
        }
        return  money;
    }

    public  boolean Login(){
        System.out.print("\tEnter user name :");
        String userName=scanner.nextLine();
        System.out.print("\tEnter password: ");
        String pass=scanner.nextLine();
        if(userName.equals("admin")&& pass.equals("1234")){
            return  true;
        }
        else {
            System.out.println("\tUser name or pass is fail");
            return  false;
        }
    }

}
