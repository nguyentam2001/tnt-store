package dao.impl;
import dao.CustomerDAO;
import model.Customer;
import util.DBUtil;
import util.Resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public int save(Customer customer) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql= Resources.INSERT_CUSTOMER;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement= DBUtil.getInstance().statementBinding( preparedStatement,customer.getFullName()
                    ,customer.getPhoneNumber(),customer.getEmail(),customer.getAddressId());
            if(preparedStatement!=null){
                return  preparedStatement.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int delete(int id) {
        return 0;
    }
    @Override
    public List<Customer> findAll() {
        return null;
    }
    @Override
    public Customer getById(int id) {
        return null;
    }
    @Override
    public int update(int id, Customer customer) {
        return 0;
    }
}
