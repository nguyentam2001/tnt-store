
package service;

import model.Discount;

public interface DiscountService extends CommonService<Discount> {
    Discount getDiscountById(int id);
}

