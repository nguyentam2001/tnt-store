package controller;

import service.AddressService;
import service.impl.AddressServiceImpl;
import util.Resources;
import util.Validator;
import view.CommonView;

import java.util.Scanner;


public class Main {
    private static AddressService addressService= new AddressServiceImpl();
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        int pick=0;
        do {
            CommonView.getInstance().mainMenu();
            pick= scanner.nextInt();
            switch (pick){
                case 1: customerOrderMenuController(); break;
                case 2: managementMenuController();break;
                default: break;
            }

        }while (pick!=0);

    }

    public  static  void  customerOrderMenuController(){
        int pick=0;
        do {
            CommonView.getInstance().customerMenu();
            pick =scanner.nextInt();
            switch (pick){
                case 1: break;//đặt hàng
                case 2: break;//xem hoá đơn by số điện thoại
                case 0: break; //THoát
            }
        }while (pick!=0);
    }

    public  static  void  managementMenuController(){
        if(Validator.getInstance().Login()){
            int pick=0;
            do {

                CommonView.getInstance().managementMenuMenu();
                pick=scanner.nextInt();
                switch (pick){
                    case 1: AddressController.getInstance().menuAddressController(); break;
                    case 2:CustomerController.getInstance().customerMenuController(); break;
                }
            }while (pick!=0);
        }
    }

    public  static boolean isContinue(){
        System.out.println(Resources.CONTINUE_MSG);
        System.out.println(Resources.EXIT_MSG);
        int result= scanner.nextInt();
        if(result==1){
            return true;
        }
        return false;
    }
}
