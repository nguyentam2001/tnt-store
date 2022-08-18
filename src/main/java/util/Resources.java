package util;

public final class Resources {

    //Account
    public static final String ACCOUNT = "admin";
    public static final String PASS = "1234";
    //Message
    public static final String ADD_SUCCESS_MSG = "Add success";
    public static final String ADD_FAIL_MSG = "Add fail";
    public static final String CONTINUE_MSG = "1. Do you want continue";
    public static final String EXIT_MSG = "2. Exit to menu";
    public static final String DELETE_SUCCESS_MSG = "Delete success";
    public static final String DELETE_FAIL_MSG = "Delete fail";
    public static final String UPDATE_FAIL_MSG = "Update fail";
    public static final String UPDATE_SUCCESS_MSG = "Update success";
    public static final String ADDRESS_NOT_EXIST = "Address is not exist with id = ";
    public static final String NAME_AND_PHONE_MSG = "Full name of customer or phone number is null";
    public static final String CUSTOMER_NOT_EXIST = "Customer is not exist ";
    public static final String PHONE_IS_EXIST = "Phone number is exist";
    //Sql
    public static final String INSERT_ADDRESS = "INSERT INTO ADDRESS(CITY,DISTRICT,SUB_DISTRICT,POSTAL_CODE,DELIVERY_FEE)" +
            " VALUES(?,?,?,?,?)";
    public static final String SELECT_ALL_ADDRESS = "SELECT * FROM  [ADDRESS]";
    public static final String DELETE_ADDRESS_BY_ID = "DELETE  [ADDRESS] WHERE ADDRESS_ID = ";

    public static final String SELECT_ADDRESS_BY_ID = "SELECT * FROM [ADDRESS] WHERE ADDRESS_ID = ";

    public static final String UPDATE_ADDRESS = "UPDATE ADDRESS SET " + " CITY = ? " + ", DISTRICT = ? "
            + ", SUB_DISTRICT = ? " + ", POSTAL_CODE= ? " + ", DELIVERY_FEE = ? " + "WHERE ADDRESS_ID = ?";
    public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER(FULL_NAME,PHONE_NUMBER,EMAIL,ADDRESS_ID)" +
            " VALUES(?,?,?,?)";
    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM  CUSTOMER";
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ";
    public static final String DELETE_CUSTOMER = "DELETE CUSTOMER WHERE CUSTOMER_ID = ";
    public static final String UPDATE_CUSTOMER = "UPDATE CUSTOMER SET " + " FULL_NAME = ? " + ", PHONE_NUMBER = ? "
            + ", EMAIL = ? " + ", ADDRESS_ID= ? " + "WHERE CUSTOMER_ID = ?";
    public static final String SELECT_CUSTOMER_BY_PHONE = "SELECT * FROM CUSTOMER WHERE PHONE_NUMBER = ";
    //Discount
    public static final String INSERT_DISCOUNT = "INSERT INTO DISCOUNT(TITLE,TYPE,DISCOUNT_PRICE,START_DATE,END_DATE) " +
            "VALUES(?,?,?,?,?)";
    public static final String DELETE_DISCOUNT_BY_ID = "DELETE  [DISCOUNT] WHERE DISCOUNT_ID = ";
    public static final String SELECT_ALL_DISCOUNT = "SELECT * FROM  [DISCOUNT ]";
    public static final String SELECT_DISCOUNT_BY_ID = "SELECT * FROM [DISCOUNT] WHERE DISCOUNT_ID = ";
    public static final String UPDATE_DISCOUNT = "UPDATE DISCOUNT SET " + " TITLE = ? " + ", TYPE = ? " +
            ", DISCOUNT_PRICE = ? " + ", START_DATE= ? " + ", END_DATE = ? " + "WHERE DISCOUNT_ID = ?";
    public static final String INSERT_ORDER = "INSERT INTO [ORDER](NAME, PHONE_NUMBER, DETAIL_ADDRESS, TOTAL" +
            ", ORDER_DATE, CUSTOMER_ID, ADDRESS_ID, DISCOUNT_ID) VALUES(?,?,?,?,?,?,?,?)";
    public static final String DELETE_ORDER_BY_ID = "DELETE  [ORDER] WHERE ORDER_ID = ";
    public static final String SELECT_ALL_ORDER = "SELECT * FROM  [ORDER]";
    public static final String SELECT_ALL_ORDER_BY_PHONE = "SELECT * FROM  [ORDER] WHERE PHONE_NUMBER = ";
    public static final String SELECT_ORDER_BY_ID = "SELECT * FROM [ORDER] WHERE ORDER_ID = ";
    public static final String UPDATE_ORDER = "UPDATE [ORDER] SET " + " NAME = ? " + ", PHONE_NUMBER = ? " + ", " +
            "DETAIL_ADDRESS = ? " + ", TOTAL = ? " + ", ORDER_DATE = ? " + ", CUSTOMER_ID = ?"
            + ", DISCOUNT_ID = ?" + ", ADDRESS_ID = ?" + " WHERE ORDER_ID = ?";

    public static final String DISCOUNT_NOT_EXIST = "Discount is not exist with id = ";
    public static final String ORDER_NOT_EXIST = "Order is not exist with id = ";
    //Order detail
    public static final String INSERT_ORDER_DETAIL = "INSERT INTO ORDER_DETAIL (QUANTITY,TOTAL,ORDER_ID,PRODUCT_ID) " +
            "VALUES(?,?,?,?)";
    public static final String UPDATE_ORDER_DETAIL = "UPDATE ORDER_DETAIL SET QUANTITY = ?, TOTAL = ?, ORDER_ID = ?, " +
            "PRODUCT_ID= ? WHERE CART_ID = ?";
    public static final String SELECT_ORDER_DETAIL_BY_ORDER_ID = "SELECT * FROM [ORDER_DETAIL] WHERE ORDER_ID = ";
    public static final String DELETE_ORDER_DETAIL = "DELETE ORDER_DETAIL WHERE CART_ID = ";
    public static final String SELECT_ALL_ORDER_DETAIL = "SELECT * FROM ORDER_DETAIL";
    public static final String SELECT_ORDER_DETAIL_BY_ID = "SELECT * FROM ORDER_DETAIL WHERE CART_ID = ";
    //Product
    public static final String INSERT_PRODUCT = "INSERT INTO [PRODUCT]([NAME],[DESCRIPTION],PRICE,DISCOUNT_PRICE,STOCK," +
            "SOLD,CREATE_DATE,[STATUS]) VALUES (?,?,?,?,?,?,?,?)";
    public static final String UPDATE_PRODUCT = "UPDATE [PRODUCT] SET [NAME] = ?, [DESCRIPTION] = ?, PRICE=?, DISCOUNT_PRICE=?" +
            ", STOCK = ?, SOLD = ?,CREATE_DATE=?,[STATUS]=? WHERE PRODUCT_ID=?";
    public static final String DELETE_PRODUCT = "DELETE PRODUCT WHERE PRODUCT_ID = ";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ";
    public static final String SELECT_PRODUCT = "SELECT * FROM PRODUCT";
    //Regex
    public static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String DATE_FORMAT = "yyyy/MM/dd";
    public static final String PHONE_REGEX = "^[0]+[0-9]{9}$";


}
