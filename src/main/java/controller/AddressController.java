package controller;

import model.Address;
import service.AddressService;
import service.impl.AddressServiceImpl;
import util.Resources;
import view.CommonView;
import view.address.AddressView;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddressController {
    private static AddressService addressService;
    private static Address address;
    private  static  AddressController instance;

    public AddressController() {
        address = new Address();
        addressService = new AddressServiceImpl();
    }

    public static   AddressController  getInstance(){
        return  instance=instance==null?new AddressController():instance;
    }

    public  void  menuAddressController(){
            int pick=0;
            do {
                AddressView.printViewAddress();
                pick=Main.scanner.nextInt();
                switch (pick){
                    case 1:saveAddressController(); break;
                    case 2:printAllAddressController(); break;
                    case 3:updateAddressController();break;
                    case 4:deleteAddressController(); break;
                    case 5:findAddressByIdController();break;
                    default: break;
                }

            }while (pick!=0);
    }

    private void findAddressByIdController() {
    }

    public  void saveAddressController() {
        boolean isCon;
        do {
            address = AddressView.inputAddress();
            boolean result=addressService.save(address);
            if(result){
                CommonView.getInstance().displayMessage(Resources.ADD_SUCCESS_MSG);
            }else {
                CommonView.getInstance().displayMessage(Resources.ADD_FAIL_MSG);
            }
            isCon=Main.isContinue();
        }while (isCon);

    }

    public void  deleteAddressController(){
        int id=CommonView.getInstance().inputId("Address");
        boolean result= addressService.delete(id);
        if(result){
            CommonView.getInstance().displayMessage(Resources.DELETE_SUCCESS_MSG);
        }else{
            CommonView.getInstance().displayMessage(Resources.DELETE_FAIL_MSG);
        }
    }

    public void printAllAddressController(){
        List<Address> addresses= addressService.findAll();
        AddressView.titleAddress();
        for (Address address :
                addresses) {
            AddressView.printAddress(address);
        }
        AddressView.printLineAddress();
    }

    public  void  updateAddressController(){
        //nhập id muốn update
        int id=CommonView.getInstance().inputId("Address");
        address = AddressView.inputAddress();
        boolean result= addressService.update(id,address);
    }

}
