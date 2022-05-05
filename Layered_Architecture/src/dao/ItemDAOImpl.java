package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements CrudDao<ItemDTO,String> {



    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");

        ArrayList<ItemDTO>allItems=new ArrayList<>();
        while (rst.next()){
            String code = rst.getString(1);
            String description = rst.getString(2);
            BigDecimal price = rst.getBigDecimal(3);
            int qtyOnHand = rst.getInt(4);
            allItems.add(new ItemDTO(code,description,price,qtyOnHand));
        }
        return allItems;
    }
    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {

        return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
                dto.getCode(),dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());

    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                dto.getDescription() , dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }
    @Override
    public boolean exists(String code) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?", code);
        return resultSet.next();
    }
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
}
