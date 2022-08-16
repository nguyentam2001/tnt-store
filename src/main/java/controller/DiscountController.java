package controller;

import model.Discount;
import service.DiscountService;
import service.impl.DiscountServiceImpl;
import util.Resources;
import view.CommonView;
import view.DiscountView;

import java.util.List;

public class DiscountController {
    private static DiscountService discountService;
    private static Discount discount;
    private  static  DiscountController instance;

    public DiscountController() {
        discount = new Discount();
        discountService = new DiscountServiceImpl();
    }

    public static DiscountController getInstance(){
        return  instance=instance==null?new DiscountController():instance;
    }

    public  void  menuDiscountController(){
        int pick=0;
        do {
            DiscountView.printViewDiscount();
            pick=Main.scanner.nextInt();
            switch (pick){
                case 1:saveDiscountController(); break;
                case 2:printAllDiscountController(); break;
                case 3:updateDiscountController();break;
                case 4:deleteDiscountController(); break;
                case 5:findDiscountByIdController();break;
                default: break;
            }

        }while (pick!=0);
    }

    private void findDiscountByIdController() {
    }

    public  void saveDiscountController() {
        boolean isCon;
        do {
            discount = DiscountView.inputDiscount();
            boolean result=discountService.save(discount);
            if(result){
                CommonView.getInstance().displayMessage(Resources.ADD_SUCCESS_MSG);
            }else {
                CommonView.getInstance().displayMessage(Resources.ADD_FAIL_MSG);
            }
            isCon=Main.isContinue();
        }while (isCon);

    }

    public void  deleteDiscountController(){
        int id=CommonView.getInstance().inputId("Discount");
        boolean result= discountService.delete(id);
        if(result){
            CommonView.getInstance().displayMessage(Resources.DELETE_SUCCESS_MSG);
        }else{
            CommonView.getInstance().displayMessage(Resources.DELETE_FAIL_MSG);
        }
    }

    public void printAllDiscountController(){
        List<Discount> discounts= discountService.findAll();
        DiscountView.titleDiscount();
        for (Discount discount :
                discounts) {
            DiscountView.printDiscount(discount);
        }
        DiscountView.printLineDiscount();
    }

    public  void  updateDiscountController(){
        //nhập id muốn update
        boolean isCon=true;
        do {
            int id=CommonView.getInstance().inputId("Discount");
            discount = DiscountView.inputDiscount();
            boolean result= discountService.update(id,discount);
            if(result){
                CommonView.getInstance().displayMessage(Resources.UPDATE_SUCCESS_MSG);
            }else{
                CommonView.getInstance().displayMessage(Resources.UPDATE_FAIL_MSG);
            }
            isCon=Main.isContinue();
        }while (isCon);

    }
}
