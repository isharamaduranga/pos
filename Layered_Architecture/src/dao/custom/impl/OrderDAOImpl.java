package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.OrderDAO;
import model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl   implements OrderDAO {

   @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.executeUpdate("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                dto.getOrderId(), dto.getOrderDate(), dto.getCustomerId());
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exists(String oid) throws SQLException, ClassNotFoundException {
        
        ResultSet rst = SQLUtil.executeQuery("SELECT oid FROM `Orders` WHERE oid=?", oid);
        return rst.next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        
        ResultSet rst = SQLUtil.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace
                ("OID-", "")) + 1)) : "OID-001";

    }
}
