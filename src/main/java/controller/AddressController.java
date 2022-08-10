package controller;

import model.Address;
import service.AddressService;
import service.impl.AddressServiceImpl;
import util.Resources;
import view.CommonView;
import view.address.AddressView;

public class AddressController {
    private static AddressService addressService;
    private static Address address;

    public AddressController() {
        address = new Address();
        addressService = new AddressServiceImpl();
    }

    public static void saveAddress() {
        address = AddressView.setAddress();
        boolean result=addressService.save(address);
        if(result){
            CommonView.displayMessage(Resources.ADD_SUCCESS_MSG);
        }else {
            CommonView.displayMessage(Resources.ADD_FAIL_MSG);
        }
    }


}
