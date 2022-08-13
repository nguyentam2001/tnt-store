package util;

public class Resources {

    /*============================ Address============================*/
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
    //Sql
    public static final String INSERT_ADDRESS = "INSERT INTO ADDRESS(CITY,DISTRICT,SUB_DISTRICT,POSTAL_CODE,DELIVERY_FEE) VALUES(?,?,?,?,?)";
    public static final String SELECT_ALL_ADDRESS = "SELECT * FROM  [ADDRESS]";
    public static final String DELETE_ADDRESS_BY_ID = "DELETE  [ADDRESS] WHERE ADDRESS_ID = ";

    public static final String SELECT_ADDRESS_BY_ID = "SELECT * FROM [ADDRESS] WHERE ADDRESS_ID = ";

    public static final String UPDATE_ADDRESS = "UPDATE ADDRESS SET " + " CITY = ? " + ", DISTRICT = ? " + ", SUB_DISTRICT = ? " + ", POSTAL_CODE= ? " + ", DELIVERY_FEE = ? " + "WHERE ADDRESS_ID = ?";
    public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER(FULL_NAME,PHONE_NUMBER,EMAIL,ADDRESS_ID) VALUES(?,?,?,?)";

    public static final String PHONE_IS_EXIST = "Phone number is exist";
    //Regex
    public static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
}
