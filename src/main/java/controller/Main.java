package controller;

import model.Address;
import service.AddressService;
import service.impl.AddressServiceImpl;
import util.Resources;
import view.CommonView;

public class Main {
    private static AddressService addressService= new AddressServiceImpl();
    public static void main(String[] args) {
        Address address = new Address(1,"Bac Giang","Bg.prc","bg","bg0124",1000);
        boolean result=addressService.save(address);
        if(result){
            CommonView.displayMessage(Resources.ADD_SUCCESS_MSG);
        }else {
            CommonView.displayMessage(Resources.ADD_FAIL_MSG);
        }
    }
}
