
package service.impl;

import dao.DiscountDAO;
import dao.impl.DiscountDAOImpl;
import model.Discount;
import service.DiscountService;
import util.Resources;
import util.Validator;
import view.CommonView;

import java.util.List;

public class DiscountServiceImpl implements DiscountService {
    private DiscountDAO discountDAO;
    public DiscountServiceImpl(){
        discountDAO = new DiscountDAOImpl();
    }
    @Override
    public boolean save(Discount discount) {
        if (Validator.getInstance().checkEmpty(discount.getTitle()))
            return false;
        else
            return discountDAO.save(discount) > 0;
    }

    @Override
    public boolean delete(int id) {
        Discount discount = discountDAO.getById(id);
        if (discount != null) {
            return discountDAO.delete(id) > 0;
        } else {
            CommonView.getInstance().displayMessage(Resources.DISCOUNT_NOT_EXIST + id);
        }
        return false;
    }

    @Override
    public List<Discount> findAll() {
        return discountDAO.findAll();
    }

    @Override
    public boolean update(int id, Discount discount) {
        Discount currDiscount = discountDAO.getById(id);
        if (currDiscount != null) {
            return discountDAO.update(id, discount) > 0;
        } else {
            CommonView.getInstance().displayMessage(Resources.DISCOUNT_NOT_EXIST + id);
        }
        return false;
    }
}

