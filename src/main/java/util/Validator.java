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
        System.out.print("Enter email: ");
        String email=scanner.nextLine();
        boolean result= Pattern.compile(Resources.EMAIL_REGEX, Pattern.CASE_INSENSITIVE).matcher(email).find();
        if(result){
            return  email;
        }
        return  emailValidate();
    }

}
