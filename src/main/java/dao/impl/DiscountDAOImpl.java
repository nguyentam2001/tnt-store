package dao.impl;

import dao.DiscountDAO;
import model.Discount;
import util.DBUtil;
import util.Resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiscountDAOImpl implements DiscountDAO {
    @Override
    public int save(Discount discount) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.INSERT_DISCOUNT;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,
                     discount.getTitle(), discount.getType(), discount.getDiscountPrice(),
                     discount.getStartDate(),discount.getEndDate());
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
            String sql = Resources.DELETE_DISCOUNT_BY_ID + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = Resources.SELECT_ALL_DISCOUNT;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Discount> discounts = new ArrayList<>();
            while (resultSet.next()) {
                Discount discount = (Discount) DBUtil.getInstance().columnBinding(new Discount(), resultSet);
                discounts.add(discount);
            }
            return discounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Discount getById(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql_select = Resources.SELECT_DISCOUNT_BY_ID + id;
            ResultSet resultSet = statement.executeQuery(sql_select);
            Discount discount;
            if(resultSet.next()) {
                discount = (Discount) DBUtil.getInstance().columnBinding(new Discount(), resultSet);
                return discount;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int update(int id, Discount discount) {
        try (Connection connection = DBUtil.getInstance().getConnection()
        ) {
            String sql = Resources.UPDATE_DISCOUNT;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DBUtil.getInstance().statementBinding(preparedStatement,
                     discount.getTitle(), discount.getType(), discount.getDiscountPrice(), discount.getStartDate(),
                    discount.getEndDate(),id);
            if (preparedStatement != null) {
                return preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
