package dao.impl;
import dao.CustomerDAO;
import model.Customer;
import util.DBUtil;
import util.Resources;
import view.CommonView;
import java.sql.*;
import java.util.ArrayList;
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
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql= Resources.DELETE_CUSTOMER+id;
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            return  preparedStatement.executeUpdate();
        }catch (SQLException e){
           CommonView.getInstance().displayMessage(e.getMessage());
        }
        return 0;
    }
    @Override
    public List<Customer> findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.SELECT_ALL_CUSTOMER;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = (Customer) DBUtil.getInstance().columnBinding(new Customer(), resultSet);
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Customer getById(int id) {
        try(Connection connection= DBUtil.getInstance().getConnection();
            Statement statement= connection.createStatement()){
            String sql= Resources.SELECT_CUSTOMER_BY_ID;
            ResultSet resultSet= statement.executeQuery(sql);
            if(resultSet.next()){
                Customer customer= (Customer) DBUtil.getInstance().columnBinding(new Customer(),resultSet);
                return  customer;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int update(int id, Customer customer) {
        try(Connection connection= DBUtil.getInstance().getConnection()) {
            String sql= Resources.UPDATE_CUSTOMER+id;
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement= DBUtil.getInstance().statementBinding(preparedStatement,
                    customer.getFullName(),customer.getPhoneNumber(),customer.getEmail(),customer.getAddressId(),id);
            if(preparedStatement!=null){
                return  preparedStatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
