package dao.impl;

import dao.AddressDAO;
import model.Address;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddressDAOImpl implements AddressDAO {
    @Override
    public int save(Address address) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="INSERT INTO ADDRESS(CITY,DISTRICT,SUB_DISTRICT,POSTAL_CODE,DELIVERY_FEE) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,address.getCity());
            preparedStatement.setString(2,address.getDistrict());
            preparedStatement.setString(3,address.getSubDistrict());
            preparedStatement.setString(4,address.getPostalCode());
            preparedStatement.setLong(5,address.getDeliveryFree());
            return  preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return  0;
        }
    }
}
