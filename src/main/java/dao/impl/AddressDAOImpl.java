package dao.impl;

import dao.AddressDAO;
import model.Address;
import util.DBUtil;
import util.Resources;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    @Override
    public int save(Address address) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.INSERT_ADDRESS;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,
                    address.getCity(), address.getDistrict(), address.getSubDistrict(), address.getPostalCode(), address.getDeliveryFree());
            if (preparedStatement != null) {
                return preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection()
        ) {
            String sql = Resources.DELETE_ADDRESS_BY_ID + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Address> findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.SELECT_ALL_ADDRESS;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Address> addresses = new ArrayList<>();
            while (resultSet.next()) {
                Address address = (Address) DBUtil.getInstance().columnBinding(new Address(), resultSet);
                addresses.add(address);
            }
            return addresses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Address getById(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql_select = Resources.SELECT_ADDRESS_BY_ID + id;
            ResultSet resultSet = statement.executeQuery(sql_select);
            Address address;
           if(resultSet.next()) {
               address= (Address) DBUtil.getInstance().columnBinding(new Address(), resultSet);
                return address;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int id, Address address) {
        try (Connection connection = DBUtil.getInstance().getConnection()
        ) {
            String sql = Resources.UPDATE_ADDRESS;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,
                    address.getCity(), address.getDistrict(), address.getSubDistrict(), address.getPostalCode(), address.getDeliveryFree(), id);
            if (preparedStatement != null) {
                return preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
