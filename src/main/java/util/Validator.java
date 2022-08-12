package util;

public class Validator {
    private  static  Validator instance;
    public  static  Validator getInstance(){
        return  instance=instance==null?new Validator():instance;
    }
    public  boolean checkEmpty(String string){
        if(string.trim().isEmpty()){
            return  true;
        }
        return  false;
    }
}
